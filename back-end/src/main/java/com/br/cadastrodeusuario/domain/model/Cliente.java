package com.br.cadastrodeusuario.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@Table(name = "CLIENTE_TBL")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "nome")
	private String nome;
	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "idade")
	private int idade;
	
	@Column(name = "pais")
	private String pais; //é o país de origem, exemplo Brasil. 
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "endereco")
	private String endereco;
}
