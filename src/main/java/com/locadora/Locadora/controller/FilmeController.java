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
	@GetMapping("/filme/{id}")
	public Filme listaFilmeUnico(@PathVariable(value= "id")long id ) {
			return filmeService.listaFilmeUnico(id);
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
}
 