package com.locadora.Locadora.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;
import com.locadora.Locadora.models.Autor;
import com.locadora.Locadora.service.AutorService;

@RestController
@RequestMapping(value = "/api")
public class AutorController {
	@Autowired
	AutorService autorService;

	@GetMapping("/autores")
	public ResponseEntity<?> listaAUtor() {
		try {
			List<Autor> listAutor = autorService.listaCategoria();
			if (listAutor.isEmpty()) {
				throw new Exception("Usuario não encontrada");
			}
			return new ResponseEntity<List<Autor>>(listAutor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

		}

	}

	@PostMapping("/autor")
	public ResponseEntity<?> saveAutor(@RequestBody @Valid Autor autor) {
		try {
			Autor saveAut = autorService.saveAutor(autor);
			return new ResponseEntity<Autor>(saveAut, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("erro ao salvar autor", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/autor/{id}")
	public ResponseEntity<String> deleteAutor(@PathVariable(value = "id") long id) {
		try {
			autorService.deleteAutor(id);
			return new ResponseEntity<String>("Autor de id" + id + " excluido com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro desconhecido", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@PutMapping("/autor")
	public ResponseEntity<?> atualizaAutor(@RequestBody @Valid Autor autor) {
		try {
			Autor attAutor = autorService.atualizaAutor(autor);
			return new ResponseEntity<Autor>(attAutor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("erro ao atualizar autor", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
