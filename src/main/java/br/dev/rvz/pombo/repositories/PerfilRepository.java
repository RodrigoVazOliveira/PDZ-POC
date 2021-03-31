package br.dev.rvz.pombo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.dev.rvz.pombo.domain.Perfil;

public interface PerfilRepository extends CrudRepository<Perfil, Long> {
	Optional<Perfil> findByNumeroTelefone(String numeroTelefone);
}
