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
		
		try {
			conta.setPerfil(conta.getPerfil());
			conta.getPerfil().setAtivo(true);
			Conta novaConta = contaRepository.save(conta);
			
			return novaConta;
		}catch (RuntimeException e) {
			throw new RuntimeException("Não foi possível fazer o cadastrado! " + e.getMessage());
		}

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
		Optional<Conta> contaAntiga = contaRepository.findById(conta.getId());
		
		if (contaAntiga.isPresent()) {
			Conta contaTemporaria = contaAntiga.get();
			contaTemporaria.setSenha(conta.getSenha());
			Perfil perfil = contaTemporaria.getPerfil();
			perfil.setNomeCompleto(conta.getPerfil().getNomeCompleto());
			perfil.setNumeroTelefone(conta.getPerfil().getNumeroTelefone());
			perfil.setRecado(conta.getPerfil().getRecado());
			perfil.setFotoPerfil(conta.getPerfil().getFotoPerfil());
			perfil.setId(conta.getId());
			return contaRepository.save(contaTemporaria);
		}
		
		return gravarNovaConta(conta);
	}
}
