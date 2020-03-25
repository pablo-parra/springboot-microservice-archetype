package ${package}.${artifactId}.logic.impl;

import ${package}.${artifactId}.dataaccess.api.${appName}Dao;
import ${package}.${artifactId}.logic.api.${appName}Management;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of ${appName}Management Interface
 *
 */
@Component
@Slf4j
public class ${appName}ManagementImpl implements ${appName}Management {

  @Autowired
  private ${appName}Dao ${appName}Dao;

}
