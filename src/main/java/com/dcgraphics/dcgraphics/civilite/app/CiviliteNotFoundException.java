package com.dcgraphics.dcgraphics.civilite.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CiviliteNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4670435329800249499L;

	public CiviliteNotFoundException() {
    }
 
    public CiviliteNotFoundException(String message) {
        super(message);
    }
 
    public CiviliteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
 
    public CiviliteNotFoundException(Throwable cause) {
        super(cause);
    }
}