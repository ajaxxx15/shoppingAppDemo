package com.mindtree.shopping.exception;



import javax.xml.bind.ValidationException;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.mindtree.shopping.vo.Response;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Response> conflict(DataIntegrityViolationException ex) {
		String message = getMostSpecificMessage(ex);

		return new ResponseEntity<Response>(new Response(false, message), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Response> handleValidationExceptions(MethodArgumentNotValidException ex) {
		String[] erMessage = new String[1];
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String message = error.getDefaultMessage();
			erMessage[0]=message;
		
		});

		return new ResponseEntity<Response>(new Response(false, erMessage[0]), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Response> validationException(ValidationException ex) {
		String message = ex.getMessage();

		return new ResponseEntity<Response>(new Response(false, message), HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Response> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		ex.printStackTrace();

		String message = ex.getMessage();
		return new ResponseEntity<Response>(new Response(false, message), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> unhandledExceptions(Exception ex) {
		String message = NestedExceptionUtils.getMostSpecificCause(ex).getMessage();

		ex.printStackTrace();

		return new ResponseEntity<Response>(new Response(false, message), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private String getMostSpecificMessage(DataIntegrityViolationException ex) {
		String message = NestedExceptionUtils.getMostSpecificCause(ex).getMessage();

		if (message.contains("Detail:")) {
			message = message.substring(message.indexOf("Detail:") + "Detail:".length());
		}

		return message;
	}
}
