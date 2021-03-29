package br.dev.rvz.pombo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "perfis")
public class Perfil {

	private Long id;
	private String nomeCompleto;
	private String numeroTelefone;
	private String fotoPerfil;
	private Recado recado;
	private Boolean ativo = true;
	
}
