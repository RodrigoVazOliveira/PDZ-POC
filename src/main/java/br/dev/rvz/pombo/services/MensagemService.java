package br.dev.rvz.pombo.services;

import br.dev.rvz.pombo.domain.Mensagem;
import br.dev.rvz.pombo.repositories.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;

    public Mensagem enviarNovaMensagem(Mensagem mensagem) {
        mensagem.setDataHora(LocalDateTime.now());
        return mensagemRepository.save(mensagem);
    }
}
