package com.dcgraphics.dcgraphics.client.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4670435329800249499L;

	public ClientNotFoundException() {
    }
 
    public ClientNotFoundException(String message) {
        super(message);
    }
 
    public ClientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
 
    public ClientNotFoundException(Throwable cause) {
        super(cause);
    }
}
