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
	@Column(name="Id")
	public long id;
	
	@Column(name = "titulo",nullable = false)
	public String titulo_filme;
	
	@Column(name="Sinopse", nullable = false)
	public String sinopse_filme;
	
	@Column(name="Imagem", nullable = false)
	public String imagem_filme;
	
	@Column(name = "data_lancamento",nullable = false)
	public String data_lascamento;
	
	@Column(name = "Duracao",nullable = false)
	public String duracao_filme;
	
	@Column(name = "Idioma",nullable = false)
	public String idioma_filme;


	@ManyToOne
	public Categoria categoria;
	@ManyToOne
	public Idioma idioma;


}
