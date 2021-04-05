package br.dev.rvz.pombo.controllers;

import br.dev.rvz.pombo.domain.Conta;
import br.dev.rvz.pombo.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("contas/")
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Conta gravarConta(@RequestBody Conta conta) {
		try {
			return contaService.gravarNovaConta(conta);
		} catch(RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Conta> obterTodasContas() {
		return contaService.obterTodasAsContas();
	}
	
	@GetMapping("busca")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Conta procurarContaPorNumeroDeTelefone(@RequestParam String numeroTelefone) {
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
	
	@PatchMapping("{id}/")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody Conta atualizarParcialConta(@PathVariable Long id, @RequestBody Conta conta) {
		conta.setId(id);
		try {
			return contaService.atualizarParcialConta(conta);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("{id}/")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerContaPorId(@PathVariable Long idConta) {
		try {
			contaService.removerConta(idConta);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
