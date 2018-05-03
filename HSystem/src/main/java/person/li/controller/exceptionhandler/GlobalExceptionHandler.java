package person.li.controller.exceptionhandler;

import Hsystem.base.Bussiness2Exception;
import Hsystem.base.BussinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BussinessException.class)
    public ResponseEntity<String> handleIOException(BussinessException ex) {
        // prepare responseEntity
        ResponseEntity re = new ResponseEntity(ex.getMessage(),HttpStatus.PAYMENT_REQUIRED);
        return re;
    }

    @ExceptionHandler(Bussiness2Exception.class)
    public @ResponseBody String Bussiness2Exception(Bussiness2Exception ex2){
        return "1111111";
    }
}
