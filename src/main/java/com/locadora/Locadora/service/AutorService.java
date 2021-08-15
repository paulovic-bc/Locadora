package com.locadora.Locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.locadora.Locadora.models.Autor;
import com.locadora.Locadora.repository.AutorRepository;
@Service
public class AutorService {
	@Autowired
	AutorRepository autorRepository;

	public List<Autor> listaCategoria(){
		return autorRepository.findAll();
	}
	
	public Autor listaCategoriaUnico(@PathVariable(value= "id")long id ) {
			return autorRepository.findById(id);
	}
	
	public Autor saveAutor(@RequestBody Autor autor) {
		return autorRepository.save(autor);
	}
	
	public String deleteAutor(@RequestBody Autor autor) {
		autorRepository.delete(autor);
		return "deletado com sucesso";
	}
	
	public Autor atualizaAutor(@RequestBody Autor autor) {
		return autorRepository.save(autor);
	}


}
