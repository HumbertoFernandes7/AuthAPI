package io.github.humbertofernandes7.authapi.dtos.inputs;

import io.github.humbertofernandes7.authapi.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {

	private String nome;
	private String email;
	private String senha;
	private RoleEnum role;
}
