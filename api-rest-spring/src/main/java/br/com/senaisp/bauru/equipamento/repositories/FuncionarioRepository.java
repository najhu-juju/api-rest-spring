package br.com.senaisp.bauru.equipamento.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.senaisp.bauru.equipamento.models.Funcionario;

@Repository
public class FuncionarioRepository {
	private Map<Integer, Funcionario> banco =
			new HashMap<>();

public FuncionarioRepository() {
        banco.put( 1, new Funcionario( 1, "Funcionario 1"));
        banco.put( 2, new Funcionario( 2, "Funcionario 2" ));
   }
//Metodos
public List<Funcionario> listar () {
	return new ArrayList<>(banco.values());
}
public Funcionario buscarPorId( Integer id) {
	  return banco.get(id);
	}
public void salvar( Funcionario funcionario) {
    banco.put( funcionario.getId(), funcionario);
}
public Funcionario atualizar( Integer id, Funcionario funcionario) {

    if(!banco.containsKey(id)) {
        return null;
    }

    funcionario.setId(id);

    banco.put(id, funcionario);

    return funcionario;
}
public boolean excluir( Integer id) {
    return banco.remove(id) != null;
}

}
