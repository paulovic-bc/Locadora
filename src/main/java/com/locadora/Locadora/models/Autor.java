package com.locadora.Locadora.models;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="TB_AUTOR")

public class Autor implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNasc() {
		return nasc;
	}

	public void setNasc(String nasc) {
		this.nasc = nasc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public long id;
	
	@Column(name = "nome_autor",nullable = false)
	public String nome;
	
	@Column(name = "data_nasc",nullable = false)
	public String nasc;
	

}
