package io.github.humbertofernandes7.authapi.exceptions;

public class BadRequestBussinessException extends BusinessException{

	private static final long serialVersionUID = 1L;

	public BadRequestBussinessException(String message) {
		super(message);
	}
}
