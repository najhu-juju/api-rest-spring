package br.com.senaisp.bauru.equipamento.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.senaisp.bauru.equipamento.models.Cliente;
import br.com.senaisp.bauru.equipamento.repositories.ClienteRepository;


@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listar() {
        return repository.listar();
    }

    public Cliente buscarPorId(Integer id) {
        return repository.buscarPorId(id);
    }

    public void salvar(Cliente cliente) {
        repository.salvar(cliente);
    }

    public Cliente atualizar(Integer id, Cliente cliente) {
        return repository.atualizar( id, cliente);
    }

    public boolean excluir(Integer id) {
        return repository.excluir(id);
    }
}
