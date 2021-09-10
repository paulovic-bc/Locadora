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
import org.springframework.web.bind.annotation.RestController;

import com.locadora.Locadora.models.Usuario;
import com.locadora.Locadora.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/Usuarios")
	public ResponseEntity<?> listaUsuario() {
		try {
			List<Usuario> user = usuarioService.listaUsuario();
			if (user.isEmpty()) {
				throw new Exception("Usuario não encontrada");
			}
			return new ResponseEntity<List<Usuario>>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/Usuario/{id}")
	public ResponseEntity<?> listaUsuarioUnico(@PathVariable(value = "id") long id) {
		try {
			Optional<Usuario> userId = usuarioService.listaUsuarioUnico(id);
			if (userId.isEmpty()) {
				throw new Exception("Usuario não encontrada");
			}
			return new ResponseEntity<Optional<Usuario>>(userId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/Usuario")
	public ResponseEntity<?> salvaUsuario(@RequestBody @Valid Usuario usuario) {
		try {
			Usuario userSave = usuarioService.salvaUsuario(usuario);
			return new ResponseEntity<Usuario>(userSave, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("erro ao salvar usuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/Usuario")

	public ResponseEntity<?> deleteUsuario(@PathVariable(value = "id") Long id) {
		try {
			usuarioService.deleteUsuario(id);
			return new ResponseEntity<String>("Usuario de id" + id + " excluido com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao delesta Usuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/Usuario")
	public ResponseEntity<?> atualizaUsuario(@RequestBody @Valid Usuario usuario) {
		try {
			Usuario userAtt = usuarioService.atualizaUsuario(usuario);
			return new ResponseEntity<Usuario>(userAtt, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("erro ao atualizar usuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
