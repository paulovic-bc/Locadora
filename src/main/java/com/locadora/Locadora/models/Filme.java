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
@Table(name="TB_FILME")

public class Filme implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public long id;
	
	@Column(name = "nome_filme",nullable = false)
	public String nome;
	
	@Column(name = "ano_lancamento",nullable = false)
	public String ano;
	
	@ManyToOne
	public Autor autor;
	@ManyToOne
	public Categoria categoria;
	

}
