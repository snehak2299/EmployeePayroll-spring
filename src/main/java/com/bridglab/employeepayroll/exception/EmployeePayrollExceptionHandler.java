package com.bridglab.employeepayroll.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridglab.employeepayroll.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
		List<String> errMesg=errorList.stream()
				.map(objErr->objErr.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseDTO responseDTO=new ResponseDTO("Exception while processing REST request",errMesg);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception){
		ResponseDTO responseDTO=new ResponseDTO("Exception while processing REST request",exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}

	private final String message="Exception whileprocessing rest request";
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public  ResponseEntity<ResponseDTO> handHttpMessageException(HttpMessageNotReadableException exception){
		log.error("Invalid Date format",exception);
		ResponseDTO responseDto=new ResponseDTO(message,"Should date in format dd-MMM-yyyy");
		return new ResponseEntity<ResponseDTO>(responseDto , HttpStatus.BAD_REQUEST);
	}
}
