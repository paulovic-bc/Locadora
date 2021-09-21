package com.locadora.Locadora.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "TB_FILME")

public class Filme implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "Id")
	public long id;

	@Column(name = "titulo", nullable = false)
	@NotBlank
	@NotEmpty
	public String titulo_filme;

	@Column(name = "Sinopse", nullable = false)
	@NotBlank
	@NotEmpty
	public String sinopse_filme;

	@Column(name = "Imagem", nullable = false)

	public String imagem_filme;

	@Column(name = "data_lancamento", nullable = false)
	@NotBlank
	@NotEmpty
	public String data_lancamento;

	@Column(name = "Duracao", nullable = false)
	@NotBlank
	@NotEmpty
	public String duracao_filme;

	@ManyToOne
	public Categoria categoria;
	@ManyToOne
	public Idioma idioma;

}
