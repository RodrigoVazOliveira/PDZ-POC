package br.dev.rvz.pombo.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mensagens")
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode(of = {"id"})
public class Mensagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TEXT NOT NULL")
	private String mensagem;
	
	private LocalDateTime dataHora;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conversacoes_id", nullable = false)
	private Conversacao conversacao;
}
