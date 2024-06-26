package com.br.cadastrodeusuario.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidadeNaoExisteException extends RegraDeNegocioException{

	private static final long serialVersionUID = 1L;

	public EntidadeNaoExisteException(String mensagem) {
		super(mensagem);
	}
	
}
