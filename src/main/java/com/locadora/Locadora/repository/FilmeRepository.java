package com.locadora.Locadora.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.locadora.Locadora.models.Filme;
@Repository
public interface FilmeRepository extends JpaRepository<Filme,Long> {
	
	Filme findById(long id);
	
	


	

}
