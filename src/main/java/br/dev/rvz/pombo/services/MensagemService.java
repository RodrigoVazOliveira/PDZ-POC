package br.dev.rvz.pombo.services;

import br.dev.rvz.pombo.domain.Conversacao;
import br.dev.rvz.pombo.domain.Mensagem;
import br.dev.rvz.pombo.repositories.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MensagemService {

    private MensagemRepository mensagemRepository;
    private ConversacaoService conversacaoService;

    @Autowired
    public MensagemService(MensagemRepository mensagemRepository, ConversacaoService conversacaoService) {
        this.mensagemRepository = mensagemRepository;
        this.conversacaoService = conversacaoService;
    }

    public Mensagem enviarNovaMensagem(Mensagem mensagem) {
        mensagem.setDataHora(LocalDateTime.now());
        return mensagemRepository.save(mensagem);
    }

    public List<Mensagem> obterMensagensPorIdConversacao(Long idConversacao) {
        Conversacao conversacao = conversacaoService.obterConversacaoPorId(idConversacao);
        return (List<Mensagem>) mensagemRepository.findByConversacao(conversacao);
    }

    public void removerMensagemPorId(Long id) {
        Optional<Mensagem> optionalMensagem = mensagemRepository.findById(id);
        if (!optionalMensagem.isPresent()) {
            throw new RuntimeException("Não existe mensagem com id " + id);
        }
        mensagemRepository.delete(optionalMensagem.get());
    }
}
