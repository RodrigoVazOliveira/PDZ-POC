package br.dev.rvz.pombo.services;

import br.dev.rvz.pombo.domain.Contato;
import br.dev.rvz.pombo.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato gravarNovoContato(Contato contato) throws RuntimeException {
        return contatoRepository.save(contato);
    }
}