package com.app.advice;

import com.app.commons.ApiStatus;
import com.app.commons.ErrorResponse;
import com.app.exceptions.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@ResponseBody
public class MainExceptionHandler {

  @ExceptionHandler({AuthException.class})
  @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
  public ErrorResponse handleAuthException(AuthException e) {
    log.error("[ERR] Auth Exception : {}", e.getMessage());
    ErrorResponse response = new ErrorResponse();
    response.setStatus(ApiStatus.FAILED);
    response.setMessage(e.getMessage());
    return response;
  }

  @ExceptionHandler({Exception.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse handleAllOtherExceptions(Exception e) {
    log.error("[ERR] Exception : {}", e.getMessage());
    ErrorResponse response = new ErrorResponse();
    response.setStatus(ApiStatus.FAILED);
    response.setMessage(e.getMessage());
    return response;
  }
}
