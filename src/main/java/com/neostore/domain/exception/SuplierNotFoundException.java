package com.neostore.domain.exception;

import javax.ws.rs.core.Response;

public class SuplierNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public SuplierNotFoundException(String mensagem, Response.Status response) {
		super(mensagem, response);
	}
	
}