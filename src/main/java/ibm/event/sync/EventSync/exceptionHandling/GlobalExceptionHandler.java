package ibm.event.sync.EventSync.exceptionHandling;

import ibm.event.sync.EventSync.dtos.ErrorResponseDTO;
import ibm.event.sync.EventSync.exceptionHandling.exceptions.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex){
        //key fieldName, Value errorMessage
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach( (error) -> errors.put(error.getField(), error.getDefaultMessage()) );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BaseException.class)//Used for all subclasses that extends the base exception
    public ResponseEntity<ErrorResponseDTO> handleBaseException(BaseException ex) {
        //Create a new response entity to pass to frontend with current time, HttpStatus code and the error message
        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                ex.getStatus().value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(error, ex.getStatus());
    }
}
