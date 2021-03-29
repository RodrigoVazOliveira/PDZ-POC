package br.dev.rvz.pombo.repositories;

import org.springframework.data.repository.CrudRepository;

import br.dev.rvz.pombo.domain.Mensagem;

public interface MensagemRepository extends CrudRepository<Mensagem, Long> {

}
