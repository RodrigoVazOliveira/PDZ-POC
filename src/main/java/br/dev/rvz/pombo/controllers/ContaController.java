package br.dev.rvz.pombo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.dev.rvz.pombo.domain.Conta;
import br.dev.rvz.pombo.services.ContaService;

@RestController
@RequestMapping("contas/")
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Conta gravarConta(@RequestBody Conta conta) {
		return contaService.gravarNovaConta(conta);
	}
}
