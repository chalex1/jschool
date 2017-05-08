package tshop.front;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import tshop.back.exceptions.LoginAlreadyInUse;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Роднуля on 13.04.2017.
 */
@ControllerAdvice
public class ExceptionAdvice {
    Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class.getName());

    @ExceptionHandler(LoginAlreadyInUse.class)
    @ResponseBody
    public String handleLoginInUse(LoginAlreadyInUse ex, HttpServletResponse response) {
        logger.info("Login already in use");
        response.setStatus(422);// WebDAV extension 422 Unprocessable Entity
        return "login already in use";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception ex) {
        logger.warn(ex.getMessage());
        return "Exception has occured!";
    }
}
