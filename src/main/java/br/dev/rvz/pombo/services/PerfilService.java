package br.dev.rvz.pombo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.rvz.pombo.domain.Perfil;
import br.dev.rvz.pombo.repositories.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;
	
	public Perfil procurarPefilPorNumeroDeTelefone(String numerotelefone) {
		Optional<Perfil> perfil = perfilRepository.findByNumeroTelefone(numerotelefone);
		
		if (!perfil.isPresent()) {
			throw new RuntimeException("Perfil não localizado com o número " + numerotelefone);
		}
		
		return perfil.get();
	}

}
