package it.devv.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by oleg on 7/20/17
 */
@ControllerAdvice
public class ExceprionControllerHandler {
    private static final Logger logger = LogManager.getLogger(ExceprionControllerHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String processValidationError(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return "Sorry service has internal problems";
    }
}



