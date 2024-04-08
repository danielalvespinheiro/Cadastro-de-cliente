package com.br.cadastrodeusuario.api.v1.model;

import lombok.*;

@Getter
@Setter
public class ClienteModel {

	private Long id;
	private String nome;
	private String email;
	private int idade;
	private String pais;
	private String cidade;
	private String endereco;
}
