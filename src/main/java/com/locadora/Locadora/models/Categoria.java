package com.locadora.Locadora.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_Categoria")
public class Categoria {
	
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name= "id")
		private int id;

		@Column(name="nome")
		private String nome;
	}

