package com.neostore.domain.exception;

import javax.ws.rs.core.Response;

public class EmailBusinessException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public EmailBusinessException(String mensagem, Response.Status response) {
        super(mensagem, response);
    }

}