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

import com.locadora.Locadora.models.Usuario;
import com.locadora.Locadora.service.UsuarioService;

@RestController
@RequestMapping(value ="/api" )
public class UsuarioController {
	@Autowired
	UsuarioService  usuarioService;
	@GetMapping("/Usuarios")
	public List<Usuario> listaUsuario(){
		return usuarioService.listaUsuario();
	}
	@GetMapping("/Usuario/{id}")
	public Usuario listaUsuarioUnico(@PathVariable(value= "id")long id ) {
		return usuarioService.listaUsuarioUnico(id);	
		
	}
	@PostMapping("/Usuario")
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
			return usuarioService.salvaUsuario(usuario);
	}
	@DeleteMapping("/Usuario")

	public String deleteUsuario(@RequestBody Usuario usuario) {
		usuarioService.deleteUsuario(usuario);
		return "deletado com sucesso";
	}
	@PutMapping("/Usuario")
	public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
		return usuarioService.atualizaUsuario(usuario);
	}
	
}
