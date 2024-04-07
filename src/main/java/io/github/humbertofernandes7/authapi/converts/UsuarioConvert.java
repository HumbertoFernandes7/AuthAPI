package io.github.humbertofernandes7.authapi.converts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.humbertofernandes7.authapi.dtos.inputs.UsuarioInput;
import io.github.humbertofernandes7.authapi.dtos.outputs.UsuarioOutput;
import io.github.humbertofernandes7.authapi.entites.UsuarioEntity;

@Component
public class UsuarioConvert {

	@Autowired
	private ModelMapper modelMapper;

	public UsuarioEntity InputToNewEntity(UsuarioInput usuarioInput) {
		return modelMapper.map(usuarioInput, UsuarioEntity.class);
	}

	public UsuarioOutput EntityToOutput(UsuarioEntity usuarioEntity) {
		return modelMapper.map(usuarioEntity, UsuarioOutput.class);
	}
}
