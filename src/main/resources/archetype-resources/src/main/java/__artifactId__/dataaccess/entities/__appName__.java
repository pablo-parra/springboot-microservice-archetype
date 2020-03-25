package ${package}.${artifactId}.dataaccess.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * ${appName} Entity
 */
@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ${appName} {

    @Id
    @Column(name = "ID_FIELD")
    private BigInteger idField;

    @Column(name = "FIELD")
    private String field;

}
