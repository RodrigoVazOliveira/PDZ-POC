package br.dev.rvz.pombo.repositories;

import br.dev.rvz.pombo.domain.Conta;
import org.springframework.data.repository.CrudRepository;

import br.dev.rvz.pombo.domain.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Long> {
    Iterable<Contato> findByConta(Conta id);
}