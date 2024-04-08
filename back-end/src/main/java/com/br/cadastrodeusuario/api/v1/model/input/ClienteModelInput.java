package com.br.cadastrodeusuario.api.v1.model.input;

import lombok.*;

@Getter
@Setter
public class ClienteModelInput {

	private String nome;
	private String email;
	private int idade;
	private String pais;
	private String cidade;
	private String endereco;
}
