package br.dev.rvz.pombo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.dev.rvz.pombo.enumarations.Recado;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perfis")
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = {"id"})
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 80, nullable = false)
	private String nomeCompleto;
	
	@Column(length = 25, nullable = false)
	private String numeroTelefone;
	
	@Column(length = 255)
	private String fotoPerfil;
	
	@Enumerated(EnumType.STRING)
	private Recado recado;
	private Boolean ativo = true;
	
	public Perfil(Long id, String nomeCompleto, String numeroTelefone, String fotoPerfil, Recado recado,
			Boolean ativo) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.numeroTelefone = numeroTelefone;
		this.fotoPerfil = fotoPerfil;
		this.recado = recado;
		this.ativo = ativo;
	}
	
	
	
}
