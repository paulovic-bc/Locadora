package com.locadora.Locadora.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.locadora.Locadora.models.Usuario;
import com.locadora.Locadora.repository.UsuarioRepository;
import com.locadora.Locadora.service.TokenService;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
	
	TokenService tokenService;
	UsuarioRepository usuarioRepository;	
	
	public  AutenticacaoViaTokenFilter(TokenService tokenService,UsuarioRepository usuarioRepository) {
		
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		boolean valido =  tokenService.isTokenValido(token);
		if (valido) {
			autentificarCliente(token);
		}
		filterChain.doFilter(request, response);
		
	}

	private void autentificarCliente(String token) {
		Long idUsuario =  tokenService.getIdUsuario(token);
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities() );
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty()|| !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7,token.length());
		
	}

}
