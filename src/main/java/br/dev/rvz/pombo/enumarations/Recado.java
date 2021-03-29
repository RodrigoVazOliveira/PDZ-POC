package br.dev.rvz.pombo.enumarations;

public enum Recado {
	DISPONIVEL("Disponível"),
	OCUPADO("Ocupado"),
	NA_ESCOLA("Na escola"),
	NO_CINEMA("No ciname"),
	NO_TRABALHO("No trabalho"),
	BATERIA_PRESTES_A_ACABAR("Bateria prestes a acabar!"),
	NAO_POSSO_FALAR_SOMENTE_MENSAGEM("Não posso falar, somente mensagens!"),
	EM_REUNIAO("Em reunião"),
	NA_ACADEMIA("Na academia"),
	DORMINDO("Dormindo"),
	SO_CHAMADA_URGENTE("Só chamada urgente!");
	
	private String descricao;
	
	Recado(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}	
	
}
