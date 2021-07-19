package br.com.productms.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorHandler {

	private Integer status_code;
	private String message;
	
	public Integer getStatus_code() {
		return status_code;
	}
	public void setStatus_code(Integer status_code) {
		this.status_code = status_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ErrorHandler(Integer status_code, String message) {
		this.status_code = status_code;
		this.message = message;
	}
	
	

}
