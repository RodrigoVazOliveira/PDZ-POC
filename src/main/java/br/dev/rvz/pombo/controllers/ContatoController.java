package br.dev.rvz.pombo.controllers;

import br.dev.rvz.pombo.domain.Contato;
import br.dev.rvz.pombo.dto.contato.GravarContatoDTO;
import br.dev.rvz.pombo.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
