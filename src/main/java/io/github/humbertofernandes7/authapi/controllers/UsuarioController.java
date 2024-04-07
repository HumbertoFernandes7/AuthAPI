package io.github.humbertofernandes7.authapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.humbertofernandes7.authapi.converts.UsuarioConvert;
import io.github.humbertofernandes7.authapi.dtos.inputs.UsuarioInput;
import io.github.humbertofernandes7.authapi.dtos.outputs.UsuarioOutput;
import io.github.humbertofernandes7.authapi.entites.UsuarioEntity;
import io.github.humbertofernandes7.authapi.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioConvert usuarioConvert;

	@PostMapping("/cadastrar")
	public UsuarioOutput cadastrarUsuario(@RequestBody UsuarioInput usuarioInput) {
		UsuarioEntity usuarioConvertidoParaEntity = usuarioConvert.InputToNewEntity(usuarioInput);
		UsuarioEntity usuarioCadastrado = usuarioService.cadastrarUsuario(usuarioConvertidoParaEntity);
		return usuarioConvert.EntityToOutput(usuarioCadastrado);

	}
}
