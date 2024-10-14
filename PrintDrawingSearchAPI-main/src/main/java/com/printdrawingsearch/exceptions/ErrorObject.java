package com.printdrawingsearch.exceptions;

import java.util.Date;

/**
 * Represents an error object to convey information about an exception or
 * problem. This object includes details such as the error message, status code,
 * and timestamp.
 */
public class ErrorObject {

	/** The message. */
	private String message;

	/** The status code. */
	private Integer statusCode;

	/** The timestamp. */
	private Date timestamp;

	/**
	 * Default constructor for creating an empty ErrorObject.
	 */
	// Empty constructor for flexibility
	public ErrorObject() {

	}

	/**
	 * Overloaded constructor that creates an error object using the following
	 * parameters.
	 *
	 * @param statusCode the integer number code of the Error Object
	 * @param message    the message describing the cause of the Error Object
	 * @param timestamp  the timestamp the error occured
	 */
	public ErrorObject(Integer statusCode, String message, Date timestamp) {
		this.statusCode = statusCode;
		this.message = message;
		this.timestamp = timestamp;
	}

	/**
	 * Get the error message describing the error object.
	 *
	 * @return message
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
	 * @return The error timestamp
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
	 * Sets the timestamp indicating when th error occurred.
	 *
	 * @param timestamp The new timestamp.
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
