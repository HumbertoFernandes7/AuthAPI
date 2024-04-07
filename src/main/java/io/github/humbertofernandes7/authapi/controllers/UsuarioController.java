package io.github.humbertofernandes7.authapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@GetMapping
	public String getMethodName() {
		return new String("teste");
	}
	
}
