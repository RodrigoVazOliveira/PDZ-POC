package br.dev.rvz.pombo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.rvz.pombo.domain.Conta;
import br.dev.rvz.pombo.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	public Conta gravarNovaConta(Conta conta) {
		conta.setPerfil(conta.getPerfil());
		Conta novaConta = contaRepository.save(conta);
		
		return conta;
	}
}
