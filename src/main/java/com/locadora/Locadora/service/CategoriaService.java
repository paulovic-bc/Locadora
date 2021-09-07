package com.locadora.Locadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.locadora.Locadora.models.Categoria;
import com.locadora.Locadora.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> listaCategoria(){
		return categoriaRepository.findAll();
	}
	public Optional<Categoria> findOne(long id){
		return categoriaRepository.findById(id);
	}

	
	public Categoria salvaCategoria(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public void deleteCategoria(long id) {
		categoriaRepository.deleteById(id);
		
	}
	
	public Categoria atualizaCategoria(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	public Optional<Categoria> listaCategoriaUnico(@PathVariable(value= "id")long id ) {
		return categoriaRepository.findById(id);
	}
}
