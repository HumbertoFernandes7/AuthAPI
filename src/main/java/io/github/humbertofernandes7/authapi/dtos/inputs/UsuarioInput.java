package io.github.humbertofernandes7.authapi.dtos.inputs;

import io.github.humbertofernandes7.authapi.enums.CargoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {

	private String nome;
	private String email;
	private String senha;
	private CargoEnum cargo;
}
