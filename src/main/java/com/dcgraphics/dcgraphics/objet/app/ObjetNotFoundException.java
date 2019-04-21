package com.dcgraphics.dcgraphics.objet.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjetNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4670435329800249499L;

	public ObjetNotFoundException() {
    }
 
    public ObjetNotFoundException(String message) {
        super(message);
    }
 
    public ObjetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
 
    public ObjetNotFoundException(Throwable cause) {
        super(cause);
    }
}
