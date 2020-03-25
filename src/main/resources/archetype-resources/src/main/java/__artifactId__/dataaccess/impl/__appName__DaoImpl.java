package ${package}.${artifactId}.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceUnit;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Component;

import ${package}.${artifactId}.dataaccess.api.${appName}Dao;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation class of the {@link ${appName}Dao} interface functionality
 */
@Component
@Slf4j
@NoArgsConstructor
public class ${appName}DaoImpl implements ${appName}Dao {

  @PersistenceUnit
  private EntityManagerFactory entityManagerFactory;

  // /**
  //  * {@inheritDoc}
  //  */
  // @Override
  // public List findSomething(String institutionId, String ssn) {

  //   EntityManager em = this.entityManagerFactory.createEntityManager();

  //   try {
  //     log.info("Configuring query to get customer accounts for the institutionId {} and the ssn {} ...", institutionId,
  //         ssn);
  //     StoredProcedureQuery query = em.createStoredProcedureQuery(StoredProcedures.GET_CUSTOMER_ACCOUNTS, Account.class);
  //     query.registerStoredProcedureParameter(Parameters.INPUT_INSTITUTION_ID, String.class, ParameterMode.IN);
  //     query.setParameter(Parameters.INPUT_INSTITUTION_ID, institutionId);
  //     query.registerStoredProcedureParameter(Parameters.INPUT_SSN, String.class, ParameterMode.IN);
  //     query.setParameter(Parameters.INPUT_SSN, ssn);
  //     query.execute();
  //     return query.getResultList();

  //   } catch (Exception ex) {
  //     log.info(String.valueOf(ex));
  //     throw new CustomerQueryException("Couldn't complete findCustomerAccounts query: ".concat(ex.getMessage()));
  //   } finally {
  //     if (em.isOpen()) {
  //       em.close();
  //     }
  //   }
  // }

}
