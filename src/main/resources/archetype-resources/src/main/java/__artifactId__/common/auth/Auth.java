package ${package}.${artifactId}.common.auth;

import ${package}.${artifactId}.common.dtos.${appName}Request;
import ${package}.${artifactId}.common.dtos.Payload;

import java.util.Optional;

/**
 * Utilities component definition
 *
 */
public interface Auth {

  /**
   * Authorization process
   *
   * @param token the authorization token
   * @param ssn the ssn included in the request
   * @return the result of the validation
   */
  boolean isAuthorized(String token, String ssn);

  /**
   * Validates the GET movements request
   *
   * @param request the request object
   * @return the result of the validation
   */
  boolean isValidRequest(${appName}Request request);

  /**
   * Extracts the payload information from the authorization token
   *
   * @param auth the content of the 'authorization' token
   * @return the extracted {@link Payload}
   */
  Optional<Payload> extractTokenPayload(String auth);

}
