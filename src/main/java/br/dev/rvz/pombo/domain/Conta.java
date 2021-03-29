package br.dev.rvz.pombo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contas")
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode(of = {"id"})
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 25)
	private String senha;
	
	
	private List<Contato> contatos;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "perfis_id", unique = true)
	private Perfil perfil;

}
