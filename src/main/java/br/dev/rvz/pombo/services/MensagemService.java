package br.dev.rvz.pombo.services;

import br.dev.rvz.pombo.repositories.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;
}
