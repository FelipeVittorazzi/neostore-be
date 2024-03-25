package com.neostore.domain.exception;


import javax.ws.rs.core.Response;

public class EntityNotFoundException extends BusinessException {
	
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String mensagem, Response.Status response) {
		super(mensagem, response);
	}

}