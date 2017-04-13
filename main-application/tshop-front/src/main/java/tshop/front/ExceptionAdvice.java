package tshop.front;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Роднуля on 13.04.2017.
 */
@ControllerAdvice
public class ExceptionAdvice {
//TODO logger
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception ex) {

        return "Unknown error";
    }
}
