package ${package};

import static org.assertj.core.api.Fail.fail;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ValidationException;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ${package}.${artifactId}.common.constants.Parameters;
import ${package}.${artifactId}.common.dtos.${appName}Request;
import ${package}.common.TestUtils;
import ${package}.config.EmbeddedDataSourceInstance;
import ${package}.${artifactId}.logic.api.${appName}Management;


/**
 * Integration Tests
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ${appName}Application.class, initializers = EmbeddedDataSourceInstance.class)
@SpringBootTest
public class IntegrationTests {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

  @Autowired
  private ${appName}Management ${appName}Management;

  @Rule
  public final OutputCapture outputCapture = new OutputCapture();

  /**
   * Resources setup
   */
  @Before
  public void setup() {

    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
  }

  @Test
  public void someTestScenario() throws Exception {

    TestUtils.testHeader(Thread.currentThread().getStackTrace()[1].getMethodName());

    // CustomerEligibleRequest loanRequest = CustomerEligibleRequest.builder().accountType(Parameters.LOAN)
    //     .institutionId(TestUtils.Resources.INST_ID_1).ssn(TestUtils.Resources.SSN_1).build();

    // MvcResult result = httpPost(TestUtils.Resources.IS_ELIGIBLE_URL, loanRequest,
    //     TestUtils.Resources.AUTH_TOKEN_NO_VALID).andExpect(status().isUnauthorized()).andReturn();
    // ErrorDetail response = TestUtils.gson.fromJson(result.getResponse().getContentAsString(), ErrorDetail.class);
    // Assertions.assertThat(response).isNotNull();
    // Assertions.assertThat(response.getTimestamp()).isNotEmpty();
    // Assertions.assertThat(response.getUuid()).isNotNull();
    // Assertions.assertThat(response.getErrorMessage()).contains(Messages.TOKEN_ERROR);

    TestUtils.testSuccess();
  }

 private ResultActions httpPost(String url, ${appName}Request request, String token) throws Exception {

    return this.mockMvc.perform(post(url).content(TestUtils.gson.toJson(request))
        .contentType(MediaType.APPLICATION_JSON).header(Parameters.AUTHORIZATION, token).accept(MediaType.APPLICATION_JSON));
  }
}
