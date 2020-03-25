package ${package}.${artifactId}.common.dtos;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Object to be returned as a response for an incorrect request
 *
 */
@Getter
public class ErrorDetail {

  private String errorMessage;

  private String timestamp;

  private UUID uuid;

  /**
   * The constructor.
   *
   * @param errorMessage is the message inside the response
   */
  public ErrorDetail(String errorMessage) {

    this.errorMessage = errorMessage;
    this.timestamp = LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
    this.uuid = UUID.randomUUID();
  }

  /**
   *
   * @param errorMessage the message
   * @param uuid predefined uuid
   */
  public ErrorDetail(String errorMessage, UUID uuid) {

    this.errorMessage = errorMessage;
    this.timestamp = LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
    this.uuid = uuid;
  }
}
