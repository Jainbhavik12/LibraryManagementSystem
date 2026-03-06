package com.library.LibraryManagementSystem.exception;


import com.library.LibraryManagementSystem.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> handleBookNotFoundException(BookNotFoundException ex){
            ErrorLogs errorLogs = new ErrorLogs(Constants.NOT_FOUND_EXCEPTION,ex.getMessage() );
        return new ResponseEntity<>(errorLogs, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FileStorageException.class)
    public ResponseEntity<?> handleFileStorageException(FileStorageException ex){
    ErrorLogs errorLogs = new ErrorLogs(Constants.STORAGE_EXCEPTION,ex.getMessage() );
    return new ResponseEntity<>(errorLogs,  HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        ErrorLogs errorLogs = new ErrorLogs(Constants.NOT_VALID_EXCEPTION,ex.getMessage() );
        return new ResponseEntity<>(errorLogs, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception ex){
        ErrorLogs errorLogs = new ErrorLogs(Constants.GENERAL_EXCEPTION,ex.getMessage());
        return new ResponseEntity<>(errorLogs, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
