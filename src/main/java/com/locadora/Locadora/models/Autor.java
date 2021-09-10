package com.locadora.Locadora.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TB_AUTOR")

public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public long id;

	@Column(name = "Nome_autor", nullable = false)
	@NotBlank
	@NotEmpty
	public String nome_autor;

	@Column(name = "Data_nasc", nullable = false)
	@NotBlank
	@NotEmpty
	public String nasc_autor;

}
