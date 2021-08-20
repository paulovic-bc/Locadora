package com.locadora.Locadora.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.locadora.Locadora.models.Categoria;
import com.locadora.Locadora.models.Filme;
import com.locadora.Locadora.repository.FilmeRepository;


@Service
public class FilmeService {
	

		@Autowired
		FilmeRepository  filmeRepository;
		
		@Autowired
		CategoriaService  categoriaService;
	
		
		
		public List<Filme> listaFilme(){
			return filmeRepository.findAll();
		}
		
	
		public Filme salvaFilme(@RequestBody Filme filme) {
			return filmeRepository.save(filme);
		}
		
		public String deleteFilme(@RequestBody Filme filme) {
			filmeRepository.delete(filme);
			return "deletado com sucesso";
		}
		
		
		public Filme atualizaFilme(@RequestBody Filme filme) {
			return filmeRepository.save(filme);
		}

		public List<Filme> findByName(String filme){
	        return filmeRepository.searchName(filme);
	    }
		public List<Filme> findByCategoria(long id){
			Optional<Categoria> categoria= categoriaService.findOne(id);
	        List<Filme> lista = new ArrayList<Filme>();
	        if(categoria.isPresent()){
	        	lista = filmeRepository.findByCategoria(categoria.get());
	        }
	        return lista;
	        
	    }
		
		public Optional<Filme> listaFilmeUnico(@PathVariable(value= "id")long id ) {
			return filmeRepository.findById(id);
		}
		
	}

