package br.dev.rvz.pombo.services;

import br.dev.rvz.pombo.domain.Conversacao;
import br.dev.rvz.pombo.repositories.ConversacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConversacaoService {

    @Autowired
    private ConversacaoRepository conversacaoRepository;

    public Conversacao criarNovaConversacao(Conversacao conversacao) {
        return conversacaoRepository.save(conversacao);
    }

    public Conversacao obterConversacaoPorId(Long id) {
        Optional<Conversacao> optionalConversacao = conversacaoRepository.findById(id);
        if (!optionalConversacao.isPresent()) {
            throw new RuntimeException("Nenhum conversa foi localizada com ID : " + id);
        }
        return optionalConversacao.get();
    }

    public void removerConversa(Long id) {
        conversacaoRepository.delete(obterConversacaoPorId(id));
    }
}
