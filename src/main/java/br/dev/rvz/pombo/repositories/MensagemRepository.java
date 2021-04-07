package br.dev.rvz.pombo.repositories;

import br.dev.rvz.pombo.domain.Conversacao;
import org.springframework.data.repository.CrudRepository;

import br.dev.rvz.pombo.domain.Mensagem;

public interface MensagemRepository extends CrudRepository<Mensagem, Long> {
    Iterable<Mensagem> findByConversacao(Conversacao conversacao);
}
