package io.github.humbertofernandes7.authapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.humbertofernandes7.authapi.dtos.inputs.AuthInput;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping
	public String auth(@RequestBody AuthInput authInput) {
		UsernamePasswordAuthenticationToken tokenUsuario = new UsernamePasswordAuthenticationToken(authInput.getEmail(), authInput.getSenha());
		authenticationManager.authenticate(tokenUsuario);
		return "Autenticado com sucesso ";
		
	}
}