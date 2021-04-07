package br.dev.rvz.pombo.controllers;

import br.dev.rvz.pombo.domain.Conversacao;
import br.dev.rvz.pombo.services.ConversacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("conversacao/")
public class ConversacaoController {

    @Autowired
    private ConversacaoService conversacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conversacao criarNovaConversa(@RequestBody Conversacao conversacao) {
        return conversacaoService.criarNovaConversacao(conversacao);
    }

    @GetMapping("{id}/")
    @ResponseStatus(HttpStatus.OK)
    public Conversacao obterConversacaoPorId(@PathVariable Long id) {
        try {
            return conversacaoService.obterConversacaoPorId(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirConversa(@PathVariable Long id) {
        try {
            conversacaoService.removerConversa(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}