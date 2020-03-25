package ${package}.${artifactId}.service;

import ${package}.${artifactId}.common.Utils;
import ${package}.${artifactId}.common.auth.Auth;
import ${package}.${artifactId}.common.constants.Messages;
import ${package}.${artifactId}.common.constants.Parameters;
import ${package}.${artifactId}.common.dtos.${appName}Request;
import ${package}.${artifactId}.logic.api.${appName}Management;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;

/**
 * Implementation of the Accounts REST service
 *
 */
@RestController
@RequestMapping(value = Parameters.API_V1)
@Slf4j
public class ${appName}Controller {

  @Autowired
  private ${appName}Management ${appName}Management;

  @Autowired
  private Auth authenticator;

  /**
   * POST ${appName}
   *
   * @param auth : parameter
   * @param request : parameter
   * @return Returns
   */
  @PostMapping(value = Parameters.${appName}_ENDPOINT)
  public ResponseEntity<Object> ${appName}Service (@RequestBody ${appName}Request request,
                                                   @RequestHeader(name = Parameters.AUTHORIZATION) String auth) {

    log.info(Messages.Request.NEW, Parameters.${appName}_ENDPOINT,request.toString(), auth);

    ResponseEntity<Object> response = ResponseEntity.noContent().build();
    try{
      if(this.authenticator.isAuthorized(auth, /*request.getSsn()*/ "some-value")){
        if(this.authenticator.isValidRequest(request)){
          log.info(Messages.Request.AUTHORIZED_AND_VALID);
          response = ResponseEntity.ok().body(/*this.${appName}Management.findSomething(request)*/"something");
        }else{
          log.info(Messages.Request.NOT_VALID);
          throw new ValidationException(Messages.MISSING_REQUIRED_FIELD);
        }
      }else{
        log.info(Messages.Request.NOT_AUTHORIZED);
        response = Utils.Http.unauthorized();
      }

      return response;

    } catch(ValidationException vex){
      log.info(String.valueOf(vex));
      return Utils.Http.badRequest(vex.getMessage());
    } catch (Exception ex){
      log.info(String.valueOf(ex));
      return Utils.Http.internalError(ex.getMessage());
    }
  }
}
