package com.andrelake.diospringmvcjedi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JediNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

}
