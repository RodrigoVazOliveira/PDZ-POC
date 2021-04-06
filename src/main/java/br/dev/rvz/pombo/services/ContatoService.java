package br.dev.rvz.pombo.services;

import br.dev.rvz.pombo.domain.Contato;
import br.dev.rvz.pombo.domain.Perfil;
import br.dev.rvz.pombo.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}