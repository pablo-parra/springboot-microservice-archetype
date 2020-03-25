package ${package};


import ${package}.common.TestUtils;
import ${package}.${artifactId}.common.auth.AuthImpl;
import ${package}.${artifactId}.logic.api.${appName}Management;
import ${package}.${artifactId}.service.${appName}Controller;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

/**
 * Controller Tests
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {${appName}Controller.class, AuthImpl.class})
public class ControllerTests {

    @Autowired
    private ${appName}Controller controller;

    @MockBean
    private ${appName}Management ${appName}ManagementMock;


    @Test
    public void someTestScenario() {

        TestUtils.testHeader(Thread.currentThread().getStackTrace()[1].getMethodName());



        TestUtils.testSuccess();
    }


}
