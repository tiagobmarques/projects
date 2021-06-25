package com.banking.client.api;

import javax.xml.ws.WebFault;

@WebFault(name="NotFoundException")
public class NotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String msg) {
        super(msg);
    }

}