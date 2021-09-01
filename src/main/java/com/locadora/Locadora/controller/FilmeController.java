package com.locadora.Locadora.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.locadora.Locadora.service.FilmeService;
import com.locadora.Locadora.models.Filme;


@RestController
@RequestMapping(value="/api")
public class FilmeController {

	@Autowired
	FilmeService  filmeService;
	
	@GetMapping("/filmes")
	public List<Filme> listaFilme(){
		return filmeService.listaFilme();
	}

	@PostMapping("/filme")
	public Filme salvaFilme(@RequestBody Filme filme) {
		return filmeService.salvaFilme(filme);
	}
	@DeleteMapping("/filme")
	public String deleteFilme(@RequestBody Filme filme) {
	 filmeService.deleteFilme(filme);
	 return "deletado com sucesso";
	}
	
	@PutMapping("/filme")
	public Filme atualizaFilme(@RequestBody Filme filme) {
		return filmeService.atualizaFilme(filme);
	}
	
	@GetMapping("/filmeName/{filme}")
    @ResponseBody
    public List<Filme> getFilme(@PathVariable(value= "filme") String filme){
        return filmeService.findByName(filme);
    }
	@GetMapping("/filme/buscaCategoria/{id}")
	@ResponseBody
	public ResponseEntity<?>findByCategoria(@PathVariable(value= "id") long id){
		try {
			List<Filme> filme = filmeService.findByCategoria(id);
			if(filme == null) {
				return new ResponseEntity<String>("Categoria não existente",HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Filme>>(filme,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);

		}
		
	}
	@GetMapping("/filmeId/{id}")
	public Optional<Filme> listaFilmeUnico(@PathVariable(value= "id")long id ) {
		return filmeService.listaFilmeUnico(id);
	}
	
}
	


 