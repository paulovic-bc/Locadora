package com.locadora.Locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.Locadora.models.Categoria;
import com.locadora.Locadora.service.CategoriaService;

@RestController
@RequestMapping(value = "/api")
public class CategoriaController {
	@Autowired
	
	CategoriaService categoriaService;
	@GetMapping("/categorias")
	public List<Categoria> listaCategoria(){
		return categoriaService.listaCategoria();
	}
	@GetMapping("/categoria/{id}")
	public Categoria listaCategoriaUnico(@PathVariable(value= "id")long id ) {
			return categoriaService.listaCategoriaUnico(id);
	}

	@PostMapping("/categoria")
	public Categoria salvaCategoria(@RequestBody Categoria categoria) {
		return categoriaService.salvaCategoria(categoria);
	}
	@DeleteMapping("/categoria")
	public String deleteCategoria(@RequestBody Categoria categoria) {
		categoriaService.deleteCategoria(categoria);
		return "Categoria deletada com sucesso";
	}
	@PutMapping("/categoria")
	public Categoria atualizaCategoria(@RequestBody Categoria categoria) {
		return categoriaService.atualizaCategoria(categoria);
	}
	
}
