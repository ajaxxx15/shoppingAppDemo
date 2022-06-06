package com.mindtree.shopping.vo;

import java.time.LocalDateTime;

public class Response {

	private boolean success;
	private String message;

	

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
	
	public String getTimestamp() {
		return LocalDateTime.now().toString();
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
