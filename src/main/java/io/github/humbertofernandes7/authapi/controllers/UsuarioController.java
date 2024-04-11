package io.github.humbertofernandes7.authapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.humbertofernandes7.authapi.converts.UsuarioConvert;
import io.github.humbertofernandes7.authapi.dtos.inputs.UsuarioInput;
import io.github.humbertofernandes7.authapi.dtos.outputs.UsuarioOutput;
import io.github.humbertofernandes7.authapi.entites.UsuarioEntity;
import io.github.humbertofernandes7.authapi.services.UsuarioService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioConvert usuarioConvert;

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/cadastrar")
	public UsuarioOutput cadastrarUsuario(@RequestBody @Valid UsuarioInput usuarioInput) {
		UsuarioEntity usuarioConvertidoParaEntity = usuarioConvert.InputToNewEntity(usuarioInput);
		UsuarioEntity usuarioCadastrado = usuarioService.cadastrarUsuario(usuarioConvertidoParaEntity);
		return usuarioConvert.EntityToOutput(usuarioCadastrado);

	}
	
	@GetMapping("/admin")
	public String admin() {
		return new String("Você tem permissão ADMIN");
	}
	
	@GetMapping("/user")
	public String user() {
		return new String("Você tem permissão USER");
	}
}
