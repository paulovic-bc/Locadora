package com.locadora.Locadora.repository;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.locadora.Locadora.models.Categoria;
import com.locadora.Locadora.models.Filme;
@Repository
public interface FilmeRepository extends JpaRepository<Filme,Long> {
	
	
	
	@Query("SELECT f FROM Filme f WHERE LOWER(f.titulo_filme) LIKE LOWER(CONCAT('%',:titulo_filme,'%'))")
    List<Filme> searchName(String titulo_filme);
	 List<Filme> findByCategoria(Categoria categoria);
}
