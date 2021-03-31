package br.dev.rvz.pombo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "conversacoes")
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode(of = {"id"})
public class Conversacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contas_id")
	private Conta conta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contatos_id")
	private Contato contato;
	
	@OneToMany(mappedBy = "conversacao")
	private List<Mensagem> mensagens;

	public Conversacao(Conta conta, Contato contato, List<Mensagem> mensagens) {
		super();
		this.conta = conta;
		this.contato = contato;
		this.mensagens = mensagens;
	}
	
	
}
