package com.boot.demo.exception.handler;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2859292084648724403L;
	private final Long userId;
	
	public EntityNotFoundException(Long id) {
		userId = id;
	}
	
	public Long getUserId() {
		return userId;
	}

}
