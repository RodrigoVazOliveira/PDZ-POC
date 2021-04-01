package br.dev.rvz.pombo.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Conta> obterTodasContas() {
		return contaService.obterTodasAsContas();
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Conta procurarContaPorNumeroDeTelefone(@PathParam(value = "numeroTelefone") String numeroTelefone) {
		try {
			return contaService.procurarContaPorNumeroDeTelefone(numeroTelefone);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}	
	
	@PutMapping("{id}/")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Conta atualizarTodaConta(@PathVariable Long id, @RequestBody Conta conta) {
		conta.setId(id);
		return contaService.atualizarConta(conta);
	}
	
}
