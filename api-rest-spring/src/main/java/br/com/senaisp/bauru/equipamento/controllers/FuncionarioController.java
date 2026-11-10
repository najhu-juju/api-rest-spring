package br.com.senaisp.bauru.equipamento.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senaisp.bauru.equipamento.models.Funcionario;
import br.com.senaisp.bauru.equipamento.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	private FuncionarioService service;
	public FuncionarioController(FuncionarioService serv) {
		service = serv;
	}
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> listar() {
	    return ResponseEntity.ok(service.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscar(@PathVariable Integer id) {

	    Funcionario funcionario = service.buscarPorId(id);

	    if(funcionario == null) {

	        return ResponseEntity.notFound().build();
	    }

	    return ResponseEntity.ok(funcionario);
	}
	@PostMapping
	public ResponseEntity<Funcionario> cadastrar(@RequestBody Funcionario funcionario) {

	    service.salvar(funcionario);

	    return ResponseEntity.status(201).body(funcionario);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(
	            @PathVariable Integer id,
	            @RequestBody Funcionario funcionario) {

	    Funcionario atualizado = service.atualizar(id, funcionario);

	    if(atualizado == null) {

	        return ResponseEntity.notFound().build();
	    }

	    return ResponseEntity.ok(atualizado);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {

	    boolean removido = service.excluir(id);

	    if(!removido) {

	        return ResponseEntity.notFound().build();
	    }

	    return ResponseEntity.noContent().build();
	}

}
