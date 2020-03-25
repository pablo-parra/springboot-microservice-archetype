package ${package}.${artifactId}.common.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Object to handle the expected request attributes service
 *
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class ${appName}Request {

  /**
   * FIELD 1
   */
  @JsonProperty("field_Name")
  private String fieldName;

}
