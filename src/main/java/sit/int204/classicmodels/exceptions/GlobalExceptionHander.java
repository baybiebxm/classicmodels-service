package sit.int204.classicmodels.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.io.FileNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHander {
    @ExceptionHandler(FileNotFoundException.class)  // ถ้าเจอ exception ตรงนี้ให้มาทำอันนี้
    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResourceNotFound handleFileNotFound(Exception ex){
//        ResourceNotFound rnf = new ResourceNotFound(ex.getMessage());
//        return rnf;
//    }
    public ResponseEntity<ErrorResponse> handleFileNotFound(Exception ex, WebRequest request){
        ErrorResponse er = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false).substring(4)
        );
        er.addValidationError("field 1", "error 1");
        er.addValidationError("field 2", "error 2");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleNullPointer(RuntimeException exception, WebRequest request){
        ErrorResponse er = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getDescription(false).substring(4)
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleNumberFormat(RuntimeException exception, WebRequest request){
        ErrorResponse er = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getDescription(false).substring(4)
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleAllRuntime(RuntimeException exception, WebRequest request){
        ErrorResponse er = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getDescription(false).substring(4)
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }

}
