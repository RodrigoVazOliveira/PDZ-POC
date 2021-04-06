package br.dev.rvz.pombo.services;

import br.dev.rvz.pombo.domain.Conta;
import br.dev.rvz.pombo.domain.Contato;
import br.dev.rvz.pombo.domain.Perfil;
import br.dev.rvz.pombo.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ContaService contaService;

    @Autowired
    private PerfilService perfilService;

    public Contato gravarNovoContato(Contato contato) throws RuntimeException {
        buscarConta(contato);
        verificarPerfil(contato);
        contato.getPerfil().setAtivo(true);
        return contatoRepository.save(contato);
    }

    private void buscarConta(Contato contato) {
        contato.setConta(contaService.procurarContaPorId(contato.getConta()));
    }

    private void verificarPerfil(Contato contato) {
        Perfil perfil = perfilService.procurarPefilPorNumeroDeTelefone(contato.getPerfil());
        if (perfil != null) {
            contato.setPerfil(perfil);
        }
    }

    public List<Contato> obterTodosContatosPorConta(Long id) {
        Conta conta = new Conta();
        conta.setId(id);
        return (List<Contato>) contatoRepository.findByConta(conta);
    }

    public Contato atualizarContatoCompleto(Contato novoContato) {
        Optional<Contato> contatoOptional = contatoRepository.findById(novoContato.getId());

        if (!contatoOptional.isPresent()) {
            return gravarNovoContato(novoContato);
        }

        Contato contatoAntigo = contatoOptional.get();
        contatoAntigo.setBloqueio(novoContato.getBloqueio());
        contatoAntigo.getPerfil().setNomeCompleto(novoContato.getPerfil().getNomeCompleto());
        contatoAntigo.getPerfil().setNumeroTelefone(novoContato.getPerfil().getNumeroTelefone());
        contatoAntigo.getPerfil().setFotoPerfil(novoContato.getPerfil().getFotoPerfil());
        contatoAntigo.getPerfil().setAtivo(novoContato.getPerfil().getAtivo());
        contatoAntigo.getPerfil().setRecado(novoContato.getPerfil().getRecado());

        return contatoRepository.save(contatoAntigo);
    }
}