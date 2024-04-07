package io.github.humbertofernandes7.authapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CargoEnum {

	ADMIM("admim"),
	USER("user");
	
	private String cargo;
}
