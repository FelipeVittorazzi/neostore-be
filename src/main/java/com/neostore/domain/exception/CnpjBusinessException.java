package com.neostore.domain.exception;

import javax.ws.rs.core.Response;

public class CnpjBusinessException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public CnpjBusinessException(String mensagem, Response.Status response) {
        super(mensagem, response);
    }

}