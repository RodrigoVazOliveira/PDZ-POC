package br.dev.rvz.pombo.controllers;

import br.dev.rvz.pombo.domain.Mensagem;
import br.dev.rvz.pombo.services.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mensagens/")
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mensagem enviarNovaMensagem(@RequestBody Mensagem mensagem) {
        return mensagemService.enviarNovaMensagem(mensagem);
    }
}
