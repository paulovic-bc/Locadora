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
@Table(name="TB_Categoria")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name= "Id")
		public long id;

		@Column(name="Nome", nullable = false)
		public String nome_categoria;

		@Column(name="Tag", nullable = false)
		public String tag_categoria;
		
		@Column(name="Idioma", nullable = false)
		public String idioma_categoria;

		@ManyToOne
		public Idioma idioma;

	}

