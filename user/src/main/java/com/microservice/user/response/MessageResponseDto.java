package com.microservice.user.response;

import org.springframework.http.HttpStatus;

public class MessageResponseDto {
    HttpStatus httpStatus;
    String message;

    public MessageResponseDto() {
	}

	public MessageResponseDto(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
