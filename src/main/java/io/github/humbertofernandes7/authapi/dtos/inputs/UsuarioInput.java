package io.github.humbertofernandes7.authapi.dtos.inputs;

import io.github.humbertofernandes7.authapi.enums.RoleEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {

	@NotNull(message = "nome não pode ser nulo")
	private String nome;
	@NotNull(message = "email não pode ser nulo")
	private String email;
	@NotNull(message = "senha não pode ser nulo")
	private String senha;
	@NotNull(message = "role é obrigatorio")
	private RoleEnum role;
}
