package com.home.practice.aop;

import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.home.practice.exception.StudentManagementNotFoundException;
import com.home.practice.response.ApiErrorResponse;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(StudentManagementNotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) {
		ApiErrorResponse errEntity = new ApiErrorResponse("4004", ex.getMessage());
		return prepareResponseMessage(errEntity, 404);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
		//List<String> = 
		ApiErrorResponse errEntity = new ApiErrorResponse("4004", errorMessage);
		return prepareResponseMessage(errEntity, 404);
	}

	private ResponseEntity<Object> prepareResponseMessage(ApiErrorResponse errEntity, int code) {
		return new ResponseEntity<>(errEntity, HttpStatus.valueOf(code));
	}
}