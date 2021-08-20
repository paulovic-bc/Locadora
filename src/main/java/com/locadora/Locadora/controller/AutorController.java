package com.locadora.Locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.locadora.Locadora.models.Autor;
import com.locadora.Locadora.service.AutorService;



@RestController
@RequestMapping(value = "/api")
public class AutorController {
	@Autowired
	AutorService autorService;
	@GetMapping("/autores")
	public List<Autor> listaCategoria(){
		return autorService.listaCategoria();
	}
	
	@PostMapping("/autor")
	public Autor saveAutor(@RequestBody Autor autor) {
		return autorService.saveAutor(autor);
	}
	@DeleteMapping("/autor")
	public String deleteAutor(@RequestBody Autor autor) {
		autorService.deleteAutor(autor);
		return "deletado com sucesso";
	}
	@PutMapping("/autor")
	public Autor atualizaAutor(@RequestBody Autor autor) {
		return autorService.atualizaAutor(autor);
	}
	
	
}
