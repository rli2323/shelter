package kz.roman.shelter.exceptions;

import kz.roman.shelter.model.ErrorsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({GameNotFoundException.class, GameFullException.class})
    public ResponseEntity<ErrorsResponse> handleGameException(Exception ex) {
        ErrorsResponse errorResponse = new ErrorsResponse();
        errorResponse.setId(UUID.randomUUID());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDescription(ex.toString());
        log.error(errorResponse.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorsResponse> handleException(Exception ex) {
        ErrorsResponse errorResponse = new ErrorsResponse();
        errorResponse.setId(UUID.randomUUID());
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDescription(ex.getLocalizedMessage());
        log.error(errorResponse.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
