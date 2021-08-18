package com.locadora.Locadora.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="TB_Usuario")
public class Usuario  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public long id;
	
	@Column(name = "CPF",nullable = false)
	public String cpf_usuario;
	
	@Column(name = "Telefone",nullable = false)
	public String telefone_usuario;
	
	@Column(name = "email",nullable = false)
	public String email_usuario;
	
	@Column(name = "Senha",nullable = false)
	public String senha_usuario;
	
	@Column(name = "Perfil",nullable = false)
	public String perfil_usuario;
	
	@ManyToOne
	public Idioma idioma;
}
  