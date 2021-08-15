package com.locadora.Locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.Locadora.models.Filme;

public interface FilmeRepository extends JpaRepository<Filme,Long> {
	
	Filme findById(long id);

}
