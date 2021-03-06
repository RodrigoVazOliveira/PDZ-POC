package br.dev.rvz.pombo.controllers;

import br.dev.rvz.pombo.domain.Contato;
import br.dev.rvz.pombo.dto.contato.GravarContatoDTO;
import br.dev.rvz.pombo.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("contatos/")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato gravarNovoContato(@RequestBody GravarContatoDTO gravarContatoDTO) {
        return contatoService.gravarNovoContato(gravarContatoDTO.converterDtoParaContato());
    }

    @GetMapping("{id}/")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> obterTodosContatosPorConta(@PathVariable Long id) {
        return contatoService.obterTodosContatosPorConta(id);
    }

    @PutMapping("{id}/")
    @ResponseStatus(HttpStatus.CREATED)
    public Contato atualizarTodoContato(@PathVariable Long id,  @RequestBody Contato contato) {
        contato.setId(id);
        return  contatoService.atualizarContatoCompleto(contato);
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerContato(@PathVariable Long id) {
        try {
            contatoService.removerContato(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
