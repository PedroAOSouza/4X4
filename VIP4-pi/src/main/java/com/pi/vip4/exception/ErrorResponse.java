package com.pi.vip4.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

/**
 * O tipo Error response.
 *
 */
public class ErrorResponse {

  private static final Logger logger = LoggerFactory.getLogger(ErrorResponse.class); // Logger para esta classe

  private Date timestamp;
  private String status;
  private String message;
  private String details;

  /**
   * Instancia uma nova Error response.
   *
   * @param timestamp o timestamp
   * @param status    o status
   * @param message   a mensagem
   * @param details   os detalhes
   */
  public ErrorResponse(Date timestamp, String status, String message, String details) {
    this.timestamp = timestamp;
    this.status = status;
    this.message = message;
    this.details = details;
    logError(); // Chama o método de log para registrar o erro
  }

  private void logError() {
    logger.error("Erro ocorreu em: {}", timestamp);
    logger.error("Status: {}", status);
    logger.error("Mensagem: {}", message);
    logger.error("Detalhes: {}", details);
  }

  // Getters e Setters

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }
}
