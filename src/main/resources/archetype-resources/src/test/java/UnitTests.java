package ${package};

import ${package}.common.TestUtils;
import ${package}.${artifactId}.common.Utils;
import ${package}.${artifactId}.common.auth.Auth;
import ${package}.${artifactId}.common.auth.AuthImpl;
import ${package}.${artifactId}.common.constants.Parameters;
import ${package}.${artifactId}.common.dtos.Payload;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Unit tests class
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AuthImpl.class})
public class UnitTests {

  @Autowired
  private Auth auth;

  @Test
  public void extractPayloadFromThreePartsTokenSuccess() {

    TestUtils.testHeader(Thread.currentThread().getStackTrace()[1].getMethodName());

    Optional<Payload> payload = this.auth.extractTokenPayload(TestUtils.Resources.THREE_PARTS_AUTH_TOKEN);

    Assertions.assertThat(payload.isPresent()).isTrue();
    Assertions.assertThat(payload.get().getSub()).isEqualTo(Parameters.USER_MANAGEMENT_ADMIN);

    TestUtils.testSuccess();
  }

  @Test
  public void extractPayloadFromFourPartsTokenSuccess() {

    TestUtils.testHeader(Thread.currentThread().getStackTrace()[1].getMethodName());

    Optional<Payload> payload = this.auth.extractTokenPayload(TestUtils.Resources.FOUR_PARTS_AUTH_TOKEN);
    Assertions.assertThat(payload.isPresent()).isTrue();

    TestUtils.testSuccess();
  }

  @Test
  public void extractPayloadFromFivePartsTokenFails() {

    TestUtils.testHeader(Thread.currentThread().getStackTrace()[1].getMethodName());

    Optional<Payload> payload = this.auth.extractTokenPayload(TestUtils.Resources.FIVE_PARTS_AUTH_TOKEN);
    Assertions.assertThat(payload.isPresent()).isFalse();

    TestUtils.testSuccess();
  }

  @Test
  public void extractPayloadAndManageTwelveDigitsTokenSuccess() {

    TestUtils.testHeader(Thread.currentThread().getStackTrace()[1].getMethodName());

    Optional<Payload> payload = this.auth.extractTokenPayload(TestUtils.Resources.TWELVE_DIGITS_SSN_AUTH_TOKEN);
    Assertions.assertThat(payload.isPresent()).isTrue();
    Assertions.assertThat(payload.get().getPsd2Ssn()).isEqualTo(TestUtils.Resources.SHORTENED_SSN);

    TestUtils.testSuccess();
  }

  @Test
  public void isAuthorizedNotValidPayloadFails() {

    TestUtils.testHeader(Thread.currentThread().getStackTrace()[1].getMethodName());

    Boolean isAuthorized = this.auth.isAuthorized("not-valid-token", "1234");
    Assertions.assertThat(isAuthorized).isFalse();

    TestUtils.testSuccess();
  }


}
