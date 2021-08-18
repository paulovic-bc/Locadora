package com.locadora.Locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.locadora.Locadora.models.Usuario;
import com.locadora.Locadora.repository.UsuarioRepository;

@Service

public class UsuarioService {
		@Autowired
		UsuarioRepository usuarioRepository;
		
	public List<Usuario> listaUsuario(){
			return usuarioRepository.findAll();
	}
	public Usuario listaUsuarioUnico(@PathVariable(value= "id")long id ) {
			return usuarioRepository.findById(id);	
			
	}
	
	
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
			return usuarioRepository.save(usuario);
	}
	
	public String deleteUsuario(@RequestBody Usuario usuario) {
		usuarioRepository.delete(usuario);
		return "deletado com sucesso";
	}
	
	
	public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}
