package com.boot.demo.exception.message;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessage {

	private String exceptionName;

	private String message;

	private List<String> errors = new ArrayList<>();

	public ErrorMessage(String message) {
		this.message = message;
	}

	public ErrorMessage(String exceptionName, String message) {
		super();
		this.exceptionName = exceptionName;
		this.message = message;
	}

	public ErrorMessage(List<String> errors) {
		super();
		this.errors = errors;
	}

	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
