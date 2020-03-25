package ${package}.${artifactId}.common.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ${package}.${artifactId}.common.Utils;
import ${package}.${artifactId}.common.constants.Messages;
import ${package}.${artifactId}.common.constants.Parameters;
import ${package}.${artifactId}.common.dtos.${appName}Request;
import ${package}.${artifactId}.common.dtos.Payload;
import ${package}.${artifactId}.common.exceptions.TokenInfoException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Utilities component implementation
 */
@Component
@Slf4j
public class AuthImpl implements Auth {

  private Gson gson = new GsonBuilder().create();

  private static final int TWO = 2;

  private static final int THREE = 3;

  private static final int FOUR = 4;

  private static final int TWELVE = 12;


  /**
   * {@inheritDoc}
   *
   */
  @Override
  public boolean isAuthorized(String token, String ssn) {

    Optional<Payload> payload = extractTokenPayload(token);

    if (!payload.isPresent()) {
      log.error("Payload extracted from token is null or empty");
      return false;
    }

    return ((null != payload.get().getAud() && payload.get().getAud().equals(Parameters.USER_MANAGEMENT_ADMIN))
        || (null != payload.get().getSub() && payload.get().getSub().equals(Parameters.USER_MANAGEMENT_ADMIN)));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValidRequest(${appName}Request request) {

    return Boolean.TRUE;
    // REQUEST FIELDS VALIDATION
    // return  isValidInstitutionId(request.getInstitutionId()) &&
    //         isValidSsn(request.getSsn()) &&
    //         isValidAccountType(request.getAccountType()) &&
    //         isValidProductGroup(request);
  }


  // private boolean isValidSsn(String ssn){
  //   if (null == ssn || ssn.isEmpty()) {
  //     log.info(Messages.Validation.MISSING_SSN);
  //     return false;
  //   }
  //   return true;
  // }


  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<Payload> extractTokenPayload(String auth) {

    try {

      int numberOfFields = StringUtils.countOccurrencesOf(auth, ".") + 1;
      log.info("Number of parts found in token: {} (expected 3 or 4 for DK)", numberOfFields);

      byte[] decodedBytes = null;
      if (numberOfFields == THREE) {
        decodedBytes = Base64.decodeBase64(auth.split(" ")[1].split("\\.")[1]);
      } else if (numberOfFields == FOUR) {
        decodedBytes = Base64.decodeBase64(auth.split(" ")[1].split("\\.")[TWO]);
      }

      if (null == decodedBytes) {
        throw new TokenInfoException("No info could be extracted from the token");
      }

      String clientInfo = new String(decodedBytes, Charset.defaultCharset());
      log.info("Token info --> {}", clientInfo);
      Payload payload = this.gson.fromJson(clientInfo, Payload.class);
      if (null != payload.getPsd2Ssn() && payload.getPsd2Ssn().length() == TWELVE) {
        log.info("payload ssn has 12 characters, discarding first 2...");
        payload.setPsd2Ssn(payload.getPsd2Ssn().substring(TWO));
        log.info("payload ssn will be {}", payload.getPsd2Ssn());
      }
      return Optional.of(payload);
    } catch (Exception e) {
      log.info(String.valueOf(e));
      return Optional.empty();
    }
  }

}
