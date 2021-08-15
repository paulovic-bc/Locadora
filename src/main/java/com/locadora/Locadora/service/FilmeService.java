package com.locadora.Locadora.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.locadora.Locadora.models.Filme;
import com.locadora.Locadora.repository.FilmeRepository;
@Service
public class FilmeService {
	

		@Autowired
		FilmeRepository  filmeRepository;
		
		
		public List<Filme> listaFilme(){
			return filmeRepository.findAll();
		}
		
		public Filme listaFilmeUnico(@PathVariable(value= "id")long id ) {
				return filmeRepository.findById(id);
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
	}

