package com.home.credit.api.homecreditapi.Exception;

import com.home.credit.api.homecreditapi.Model.StatusCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails( StatusCode.INTERNAL_SERVER_ERROR.toString() );
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

   /* @ExceptionHandler(AuthLoginNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(AuthLoginNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails("400","Invalid","", request.getDescription(false), null);
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }*/

    private Map<String, Set<String>> processFieldErrors(List<FieldError> fieldErrors) {
        return fieldErrors.stream().
                collect(
                        Collectors.groupingBy(org.springframework.validation.FieldError::getField, Collectors.mapping(org.springframework.validation.FieldError::getDefaultMessage, Collectors.toSet())));
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String, Set<String>> validations = processFieldErrors(fieldErrors);
        ErrorDetails errorDetails = new ErrorDetails( StatusCode.BAD_REQUEST.toString(), validations);
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
