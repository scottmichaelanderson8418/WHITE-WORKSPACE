package com.workshop.app.exceptions;

/**
 * A custom runtime exception indicating that a print or drawing was not found.
 * This exception extends RuntimeException, making it an unchecked exception,
 * meaning it does not need to be explicitly declared or caught.
 */
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L; // Recommended for serializable classes

	/**
	 * Constructs a new PrintDrawingNotFoundException with the specified error
	 * message. The message is passed to the parent RuntimeException constructor to
	 * provide a description of the exception.
	 *
	 * @param message A detailed message explaining why the print or drawing was not
	 *                found.
	 */
	public UserNotFoundException(String message) {
		super(message);
	}
}
