package com.locadora.Locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.Locadora.models.Autor;


public interface AutorRepository extends JpaRepository<Autor,Long> {


	Autor findById(long id);

}
