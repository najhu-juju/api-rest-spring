package br.com.senaisp.bauru.equipamento.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.senaisp.bauru.equipamento.models.Funcionario;
import br.com.senaisp.bauru.equipamento.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<Funcionario> listar() {
        return repository.listar();
    }

    public Funcionario buscarPorId(Integer id) {
        return repository.buscarPorId(id);
    }

    public void salvar(Funcionario funcionario) {
        repository.salvar(funcionario);
    }

    public Funcionario atualizar(Integer id, Funcionario funcionario) {
        return repository.atualizar( id, funcionario);
    }

    public boolean excluir(Integer id) {
        return repository.excluir(id);
    }
}
