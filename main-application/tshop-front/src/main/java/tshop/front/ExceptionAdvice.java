package tshop.front;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import tshop.back.exceptions.LoginAlreadyInUse;
import tshop.back.exceptions.NotEnoughProducts;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Роднуля on 13.04.2017.
 */
@ControllerAdvice
public class ExceptionAdvice {
    Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class.getName());

    @ExceptionHandler({LoginAlreadyInUse.class, NotEnoughProducts.class})
    @ResponseBody
    public String handleUnprocessibleEntity(Exception ex, HttpServletResponse response) {
        logger.info(ex.getMessage());
        response.setStatus(422);// WebDAV extension 422 Unprocessable Entity
        return "Unprocessable Entity. Check the documentation for mor information.";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception ex) {
        logger.warn(ex.getMessage());
        return "Exception has occured!";
    }
}
