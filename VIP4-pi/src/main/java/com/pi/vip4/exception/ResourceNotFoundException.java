package com.pi.vip4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

  /**
   * Instancia uma nova Resource not found exception.
   *
   * @param message a mensagem
   */
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
