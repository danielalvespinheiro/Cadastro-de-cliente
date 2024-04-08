package com.br.cadastrodeusuario.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.br.cadastrodeusuario.api.v1.mapper.*;
import com.br.cadastrodeusuario.api.v1.model.ClienteModel;
import com.br.cadastrodeusuario.api.v1.model.input.ClienteModelInput;
import com.br.cadastrodeusuario.domain.model.Cliente;
import com.br.cadastrodeusuario.domain.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteModelMapper clienteModelMapper;
	
	@Autowired
	private ClienteModelMapperBack clienteModelMapperBack;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> listar(){
		
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable("id") Long id){
		
		Cliente cliente = clienteService.findId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<ClienteModel> cadastrar(@RequestBody @Valid
		ClienteModelInput userModelInput) {
		
		Cliente user = clienteModelMapperBack.toModel(userModelInput);
		
		ClienteModel userModel = clienteModelMapper.toModel(clienteService.salvar(user));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<ClienteModel> atualizar(@RequestBody @Valid
		ClienteModelInput userModelInput, @PathVariable("id") Long id) {
		
		Cliente user = clienteModelMapperBack.toModel(userModelInput);
		
		ClienteModel userModel = clienteModelMapper.toModel(clienteService.atualizar(id,user));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<Cliente> deletar(@PathVariable("id") Long id, Cliente cliente) {
		
		clienteService.deletarPorId(id);
		
		System.out.println("Cliente deletado com sucesso! ");
	
		return ResponseEntity.noContent().build();
	}
	
}
