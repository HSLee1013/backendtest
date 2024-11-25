package co.kr.metacoding.backendtest.core.error;

import co.kr.metacoding.backendtest.core.error.ex.Exception400;
import co.kr.metacoding.backendtest.core.error.ex.Exception404;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> err400(Exception400 e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> err404(Exception404 e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
