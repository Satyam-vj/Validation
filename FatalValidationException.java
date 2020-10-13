package org.jio.krishi.validation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class FatalValidationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;
	private Throwable cause;
	private List<String> details;
	public FatalValidationException(String message, List<String> details) {
		super(message);
		this.details = details;
	}
	public FatalValidationException(String message, Throwable cause, List<String> details) {
		super(message,cause);
		this.details = details;
	}
	public FatalValidationException(String message, Throwable cause) {
		super(message,cause);
		
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Throwable getCause() {
		return cause;
	}
	public void setCause(Throwable cause) {
		this.cause = cause;
	}

}
