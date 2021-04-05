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
	
	
	public Conta atualizarParcialConta(Conta conta) {
		Optional<Conta> contaAntiga = contaRepository.findById(conta.getId());
		
		if (!contaAntiga.isPresent()) {
			throw new RuntimeException("Conta não localizado!");
		}
		
		Conta contaAn = contaAntiga.get();
		Perfil perfilAn = contaAn.getPerfil();
 		
		if (!contaAn.getSenha().equals(conta.getSenha()) 
				&& conta.getSenha() != null) {
			contaAn.setSenha(conta.getSenha());
		} 
		
		
		if (!perfilAn.getNomeCompleto(conta.getPerfil().getNomeCompleto()) 
				&& conta.getPerfil().getNomeCompleto() != null) {
			perfilAn.setNomeCompleto(conta.getPerfil().getNomeCompleto());
		}
		
		if (!perfilAn.getNumeroTelefone(conta.getPerfil().getNumeroTelefone()) 
				&& conta.getPerfil().getNumeroTelefone() != null) {
			perfilAn.setNumeroTelefone(conta.getPerfil().getNumeroTelefone());
		}
		
		if (!perfilAn.getRecado(conta.getPerfil().getRecado()) 
				&& conta.getPerfil().getRecado() != null) {
			perfilAn.setRecado(conta.getPerfil().getRecado());
		}
		
		if (!perfilAn.getFotoPerfil(conta.getPerfil().getFotoPerfil()) 
				&& conta.getPerfil().getFotoPerfil() != null) {
			perfilAn.setFotoPerfil(conta.getPerfil().getFotoPerfil());
		}
		
		if (!perfilAn.getAtivo(conta.getPerfil().getAtivo()) 
				&& conta.getPerfil().getAtivo() != null) {
			perfilAn.setAtivo(conta.getPerfil().getAtivo());
		}
		
		
		return atualizarConta(contaAn);
	}
}
