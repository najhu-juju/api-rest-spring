package br.com.senaisp.bauru.equipamento.repositories;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.senaisp.bauru.equipamento.models.Cliente;


@Repository
public class ClienteRepository {
	private Map<Integer, Cliente> banco =
			new HashMap<>();

public ClienteRepository() {
        banco.put( 1, new Cliente( 1, "Cliente 1"));
        banco.put( 2, new Cliente( 2, "Cliente 2" ));
   }
//Metodos
public List<Cliente> listar () {
	return new ArrayList<>(banco.values());
}
public Cliente buscarPorId( Integer id) {
	  return banco.get(id);
	}
public void salvar( Cliente cliente) {
    banco.put( cliente.getId(), cliente);
}
public Cliente atualizar( Integer id, Cliente cliente) {

    if(!banco.containsKey(id)) {
        return null;
    }

    cliente.setId(id);

    banco.put(id, cliente);

    return cliente;
}
public boolean excluir( Integer id) {
    return banco.remove(id) != null;
}

}
