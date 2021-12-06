package com.hcl.employee.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorDetails {

	private Date timestamp;
    private String message;
    private String details;
    private HttpStatus httpStatus;
    public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}



    public Date getTimestamp() {
         return timestamp;
    }

    public String getMessage() {
         return message;
    }

    public String getDetails() {
         return details;
    }


	public ErrorDetails(Date timestamp, HttpStatus httpStatus, String message,
			String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.httpStatus = httpStatus;
	}

}
