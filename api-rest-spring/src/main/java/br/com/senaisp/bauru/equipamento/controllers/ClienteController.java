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

import br.com.senaisp.bauru.equipamento.models.Cliente;
import br.com.senaisp.bauru.equipamento.services.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	private ClienteService service;
	public ClienteController(ClienteService serv) {
		service = serv;
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
	    return ResponseEntity.ok(service.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Integer id) {

	    Cliente cliente = service.buscarPorId(id);

	    if(cliente == null) {

	        return ResponseEntity.notFound().build();
	    }

	    return ResponseEntity.ok(cliente);
	}
	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {

	    service.salvar(cliente);

	    return ResponseEntity.status(201).body(cliente);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(
	            @PathVariable Integer id,
	            @RequestBody Cliente cliente) {

	    Cliente atualizado = service.atualizar(id, cliente);

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

