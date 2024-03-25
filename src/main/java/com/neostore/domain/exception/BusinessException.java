package com.neostore.domain.exception;


import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class BusinessException extends WebApplicationException {
	
	private static final long serialVersionUID = 1L;

	public BusinessException(String mensagem) {
		super(mensagem);
	}

	public BusinessException(String mensagem, Response.Status causa) {
		super(mensagem, causa);
	}

}