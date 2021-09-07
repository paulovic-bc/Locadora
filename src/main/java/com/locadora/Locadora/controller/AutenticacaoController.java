package com.locadora.Locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.Locadora.dto.TokenDto;
import com.locadora.Locadora.models.form.LoginForm;
import com.locadora.Locadora.service.TokenService;

@RestController
@RequestMapping("api")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenManager;
	@Autowired
	TokenService tokenService;

	@PostMapping("/auth")
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Validated LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authentication = authenManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);

			return ResponseEntity.ok(new TokenDto(token, "Bearer"));

		} catch (AuthenticationCredentialsNotFoundException e) {
			return ResponseEntity.badRequest().build();
		}

	}

}
