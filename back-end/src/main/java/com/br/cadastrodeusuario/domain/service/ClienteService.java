package com.br.cadastrodeusuario.domain.service;

import java.util.List;
import com.br.cadastrodeusuario.domain.model.Cliente;

public interface ClienteService {

	List<Cliente> findAll();
	Cliente salvar(Cliente cliente);
	Cliente findId(Long id);
	Cliente atualizar(Long id, Cliente cliente);
	void deletarPorId(Long id);
}
