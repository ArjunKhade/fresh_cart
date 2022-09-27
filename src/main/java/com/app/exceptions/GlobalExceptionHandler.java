package com.app.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// handler to ResourceNotFoundException exp
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

	// handler to MethodArgumentNotValidException exp
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String defaultMessage = error.getDefaultMessage();
			resp.put(fieldName, defaultMessage);
		});
		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}

	// handler to UserHandlingException exp
	@ExceptionHandler(UserHandlingException.class)
	public ResponseEntity<ApiResponse> userHandlingExceptionHandler(UserHandlingException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	// handler to categoryHandlingException exp
	@ExceptionHandler(CategoryHandlingException.class)
	public ResponseEntity<ApiResponse> categoryHandlingExceptionHandler(CategoryHandlingException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	// handler to productHandlingException
	@ExceptionHandler(ProductHandlingException.class)
	public ResponseEntity<ApiResponse> productHandlingExceptionHandler(ProductHandlingException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	// UserHandlingException exp
//	@ExceptionHandler(BadCredentialsException.class)
//	public ResponseEntity<ApiResponse> badCredentialsExceptionHandler(BadCredentialsException ex) {
//		String message = ex.getMessage();
//		ApiResponse apiResponse = new ApiResponse(message);
//		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
//	}

	// for all remaining excs : add global exc handling method
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
	}

}
