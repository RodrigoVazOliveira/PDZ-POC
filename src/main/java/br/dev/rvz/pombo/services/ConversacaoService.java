package br.dev.rvz.pombo.services;

import br.dev.rvz.pombo.domain.Conversacao;
import br.dev.rvz.pombo.repositories.ConversacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversacaoService {

    @Autowired
    private ConversacaoRepository conversacaoRepository;

    public Conversacao criarNovaConversacao(Conversacao conversacao) {
        return conversacaoRepository.save(conversacao);
    }
}
