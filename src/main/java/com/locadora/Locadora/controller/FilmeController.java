package com.locadora.Locadora.controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

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
@RequestMapping(value = "/api")
public class FilmeController {

	@Autowired
	FilmeService filmeService;

	@GetMapping("/filmes")
	public ResponseEntity<?> listaFilme() {
		try {
			List<Filme> filme = filmeService.listaFilme();
			if (filme.isEmpty()) {
				throw new Exception("Erro desconhecido");
			}

			return new ResponseEntity<List<Filme>>(filme, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/filme")
	public ResponseEntity<?> salvaFilme(@RequestBody @Valid Filme filme) {
		try {
			Filme filmesave = filmeService.salvaFilme(filme);
			return new ResponseEntity<Filme>(filmesave, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao salvar filme", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/filme/{id}")
	public ResponseEntity<String> deleteFilme(@PathVariable(value = "id") long id) {
		try {
			filmeService.deleteFilme(id);
			return new ResponseEntity<String>("Filme de id" + id + " excluido com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao Excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/filme")
	public ResponseEntity<?> atualizaFilme(@RequestBody @Valid Filme filme) {
		try {
			Filme filmeAtt = filmeService.atualizaFilme(filme);
			return new ResponseEntity<Filme>(filmeAtt, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("erro ao atualizar filme", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/filmeName/{filme}")
	@ResponseBody
	public ResponseEntity<?> getFilme(@PathVariable(value = "filme") String filme) {
		try {
			List<Filme> filmeName = filmeService.findByName(filme);
			if (filmeName.isEmpty()) {
				throw new Exception("Filme não encontrado");
			}
			return new ResponseEntity<List<Filme>>(filmeName, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/filme/buscaCategoria/{id}")
	@ResponseBody
	public ResponseEntity<?> findByCategoria(@PathVariable(value = "id") long id) {
		try {
			List<Filme> filme = filmeService.findByCategoria(id);
			if (filme == null) {
				return new ResponseEntity<String>("Categoria não existente", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Filme>>(filme, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

	@GetMapping("/filmeId/{id}")
	public ResponseEntity<?> listaFilmeUnico(@PathVariable(value = "id") long id) {

		try {
			Optional<Filme> filme = filmeService.listaFilmeUnico(id);
			if (filme.isEmpty()) {
				throw new Exception("filme não existe");
			}
			return new ResponseEntity<Optional<Filme>>(filme, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("filme não encontrado", HttpStatus.NOT_FOUND);

		}

	}
}
