package com.br.cadastrodeusuario.api.exception;

import java.time.OffsetDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@Builder
public class Problema {

	private Integer status;
	
	private String type; 
	
	private String title;
	
	
	private String detail;
	
	
	private String userMessage;
	
	private OffsetDateTime timeStamp;
	
	private List<Object> fields;
	
	@Getter
	@Setter 
	@Builder 
	public static class Object {
		private String userMessage;
		
		private String name;
	}
}
