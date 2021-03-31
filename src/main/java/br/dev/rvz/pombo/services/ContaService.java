package br.dev.rvz.pombo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.rvz.pombo.domain.Conta;
import br.dev.rvz.pombo.domain.Perfil;
import br.dev.rvz.pombo.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private PerfilService perfilService;
	
	public Conta gravarNovaConta(Conta conta) {
		
		conta.setPerfil(conta.getPerfil());
		Conta novaConta = contaRepository.save(conta);
		
		return novaConta;
	}
	
	public List<Conta> obterTodasAsContas() {
		return (List<Conta>)  contaRepository.findAll();
	}
	
	public Conta procurarContaPorNumeroDeTelefone(String numeroTelefone) {
			
		Perfil perfil = perfilService.procurarPefilPorNumeroDeTelefone(numeroTelefone);
		Optional<Conta> conta = contaRepository.findById(perfil.getId());
		
		if (!conta.isPresent()) {
			throw new RuntimeException("Nenhuma conta foi localizada com o número " + numeroTelefone);
		}
		
		return conta.get();
	}
	
	public Conta atualizarConta(Conta conta) {
		Conta novaConta = contaRepository.save(conta);
		return novaConta;
	}
}
