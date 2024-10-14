package com.workshop.app.exceptions;

import java.util.Date;

/**
 * Represents an error object to convey information about an exception or
 * problem. This object includes details such as the error message, status code,
 * and timestamp.
 */
public class ErrorObject {

	private String message;
	private Integer statusCode;
	private Date timestamp;

	/**
	 * Default constructor for creating an empty ErrorObject.
	 */
	public ErrorObject() {
		// Empty constructor for flexibility
	}

	/**
	 * Constructs an ErrorObject with the specified status code, message, and
	 * timestamp.
	 *
	 * @param statusCode The HTTP status code indicating the type of error.
	 * @param message    A descriptive message explaining the error.
	 * @param timestamp  The date and time when the error occurred.
	 */
	public ErrorObject(Integer statusCode, String message, Date timestamp) {
		this.statusCode = statusCode;
		this.message = message;
		this.timestamp = timestamp;
	}

	/**
	 * Gets the error message describing the problem.
	 *
	 * @return The error message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the HTTP status code associated with the error.
	 *
	 * @return The status code.
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * Gets the timestamp indicating when the error occurred.
	 *
	 * @return The error timestamp.
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the error message.
	 *
	 * @param message The new error message.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Sets the status code for the error.
	 *
	 * @param statusCode The new status code.
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Sets the timestamp indicating when the error occurred.
	 *
	 * @param timestamp The new timestamp.
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
