package br.dev.rvz.pombo.repositories;

import org.springframework.data.repository.CrudRepository;

import br.dev.rvz.pombo.domain.Conta;

public interface ContaRepository extends CrudRepository<Conta, Long> {
	
}
