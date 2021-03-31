package br.dev.rvz.pombo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contatos")
@NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = {"id"})
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "perfis_id", unique = true)
	private Perfil perfil;
	private Boolean bloqueio;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contas_id", nullable = false)
	private Conta conta;
	
	@OneToOne(mappedBy = "contato")
	private Conversacao conversacao;
	
	public Contato(Perfil perfil, Boolean bloqueio) {
		super();
		this.perfil = perfil;
		this.bloqueio = bloqueio;
	}
	
	
}
