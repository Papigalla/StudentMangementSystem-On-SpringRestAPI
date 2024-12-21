package com.example.Student_Management_System.exception;

public class StudentNotFoundById extends RuntimeException{
	private String message;

	public StudentNotFoundById(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
