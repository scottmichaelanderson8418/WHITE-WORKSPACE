package com.printdrawingsearch.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * A global exception handler class for handling exceptions that occur across
 * the application. This class uses Spring's @ControllerAdvice annotation to
 * make it a component that can intercept and handle exceptions thrown by
 * controller methods.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Handles exceptions of type {@link PrintDrawingNotFoundException}. This method
	 * is annotated with @ExceptionHandler, which indicates that it should be called
	 * when this specific type of exception is thrown.
	 * 
	 * @param ex      The PrintDrawingNotFoundException that was thrown.
	 * @param request The WebRequest object associated with the request that caused
	 *                the exception.
	 * @return A ResponseEntity containing an ErrorObect with details about the
	 *         exception and an HTTP status code of NOT_FOUND.
	 */
	@ExceptionHandler(PrintDrawingNotFoundException.class)
	public ResponseEntity<ErrorObject> handlePokemonNotFoundException(
			PrintDrawingNotFoundException ex, WebRequest request) {
		ErrorObject errorObject = new ErrorObject();

		errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorObject.setMessage(ex.getMessage());
		errorObject.setTimestamp(new Date());

		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
	}

}
