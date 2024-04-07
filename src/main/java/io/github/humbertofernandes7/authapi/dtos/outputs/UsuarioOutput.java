package io.github.humbertofernandes7.authapi.dtos.outputs;

import io.github.humbertofernandes7.authapi.enums.CargoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioOutput {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private CargoEnum cargo;

}
