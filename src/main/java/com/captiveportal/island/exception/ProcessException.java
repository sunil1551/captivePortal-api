package com.captiveportal.island.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;

public class ProcessException extends Exception {

	private static final long serialVersionUID = 1L;

	private final int errorCode;
	private final Exception exception;
	private final HttpStatus httpStatus;
	private final Map<String, String> validationErrors;

	public ProcessException() {
		super();
		this.errorCode = 0;
		this.exception = null;
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.validationErrors = null;
	}

	public ProcessException(String message) {
		super(message);
		this.errorCode = 0;
		this.exception = null;
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.validationErrors = null;
	}

	public ProcessException(Throwable cause) {
		super(cause);
		this.errorCode = 0;
		this.exception = null;
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.validationErrors = null;
	}

	public ProcessException(final Exception exception) {
		super(exception);
		this.errorCode = 0;
		this.exception = exception;
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.validationErrors = null;
	}

	public ProcessException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
		this.exception = null;
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.validationErrors = null;

	}

	public ProcessException(final String message, int errorCode, final Exception exception) {
		super(message, exception);
		this.errorCode = errorCode;
		this.exception = exception;
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.validationErrors = null;
	}

	public ProcessException(final String message, final Exception exception) {
		super(message, exception);
		this.exception = exception;
		this.errorCode = 0;
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.validationErrors = null;
	}

	public ProcessException(String message, Throwable cause) {
		super(message, cause);
		this.errorCode = 0;
		this.exception = null;
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.validationErrors = null;
	}

	public ProcessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorCode = 0;
		this.exception = null;
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.validationErrors = null;
	}

	public ProcessException(String message, int errorCode, Exception exception, HttpStatus httpStatus,
			Map<String, String> validationErrors) {
		super(message);
		this.errorCode = errorCode;
		this.exception = exception;
		this.httpStatus = httpStatus;
		this.validationErrors = validationErrors;
	}

	public ProcessException(String message, int errorCode, Exception exception, HttpStatus httpStatus) {
		super(message);
		this.errorCode = errorCode;
		this.exception = exception;
		this.httpStatus = httpStatus;
		this.validationErrors = null;
	}

	public ProcessException(String message, int errorCode, HttpStatus httpStatus) {
		super(message);
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
		this.exception = null;
		this.validationErrors = null;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public Exception getException() {
		return exception == null ? this : exception;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}

}
