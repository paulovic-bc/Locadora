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
import org.springframework.web.bind.annotation.RestController;

import com.locadora.Locadora.models.Categoria;
import com.locadora.Locadora.service.CategoriaService;

@RestController
@RequestMapping(value = "/api")
public class CategoriaController {
	@Autowired

	CategoriaService categoriaService;

	@GetMapping("/categorias")
	public ResponseEntity<?> listaCategoria() {
		try {
			List<Categoria> cat = categoriaService.listaCategoria();
			if (cat.isEmpty()) {
				throw new Exception("Categoria não encontrada");
			}
			return new ResponseEntity<List<Categoria>>(cat, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/categoria")
	public ResponseEntity<?> salvaCategoria(@RequestBody Categoria categoria) {
		try {
			Categoria catSave = categoriaService.salvaCategoria(categoria);
			return new ResponseEntity<Categoria>(catSave, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("erro ao salvar categoria", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/categoria/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable(value = "id") Long id) {
		try {
			categoriaService.deleteCategoria(id);
			return new ResponseEntity<String>("Categoria de id" + id + "excluido com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro desconhecido", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/categoria")
	public ResponseEntity<?> atualizaCategoria(@RequestBody Categoria categoria) {
		try {
			Categoria catAtt = categoriaService.atualizaCategoria(categoria);
			return new ResponseEntity<Categoria>(catAtt, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("erro ao atualizar categoria", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/categoriaId/{id}")
	public ResponseEntity<?> listaCategoriaUnico(@PathVariable(value = "id") long id) {
		try {
			Optional<Categoria> catId = categoriaService.listaCategoriaUnico(id);
			if (catId.isEmpty()) {
				throw new Exception("Categoria não encontrada");
			}
			return new ResponseEntity<Optional<Categoria>>(catId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}
