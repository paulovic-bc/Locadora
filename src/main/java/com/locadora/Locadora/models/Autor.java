package com.locadora.Locadora.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_AUTOR")

public class Autor  {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "nome_autor",nullable = false)
	private String nome;
	
	@Column(name = "data_nasc",nullable = false)
	private String nasc;
	

}
