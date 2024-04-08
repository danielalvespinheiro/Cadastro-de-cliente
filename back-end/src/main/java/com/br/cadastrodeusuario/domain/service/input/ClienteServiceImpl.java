package com.br.cadastrodeusuario.domain.service.input;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.cadastrodeusuario.domain.exception.EntidadeNaoExisteException;
import com.br.cadastrodeusuario.domain.model.Cliente;
import com.br.cadastrodeusuario.domain.repository.ClienteRepository;
import com.br.cadastrodeusuario.domain.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> findAll() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Cliente salvar(Cliente cliente) {
		Cliente salva = clienteRepository.save(cliente);
	
		return salva;
	}

	@Override
	public Cliente findId(Long id) {
		Cliente achar = clienteRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoExisteException("Cliente informa não encontrado: " + id)); 
		return achar;
	}

	@Override
	public Cliente atualizar(Long id, Cliente cliente) {
		Cliente att = clienteRepository.findById(id)
	            .orElseThrow(() -> new EntidadeNaoExisteException("Cliente não encontrado: " + id));
	    
	    att.setNome(cliente.getNome());
	    att.setEmail(cliente.getEmail());
	    att.setIdade(cliente.getIdade());
	    att.setPais(cliente.getPais());
	    att.setCidade(cliente.getCidade());
	    att.setEndereco(cliente.getEndereco());
	    
	    return clienteRepository.save(att);
	}

	@Override
	public void deletarPorId(Long id) {
		clienteRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoExisteException("O cliente informado, para apagar, não foi encontrado " ));
		clienteRepository.deleteById(id);
		
	}
	
}
