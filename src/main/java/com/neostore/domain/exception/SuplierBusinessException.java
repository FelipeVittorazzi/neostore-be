package com.neostore.domain.exception;

import javax.ws.rs.core.Response;

public class SuplierBusinessException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public SuplierBusinessException(String mensagem, Response.Status response) {
        super(mensagem, response);
    }

}