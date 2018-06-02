package ua.demo.jasypt;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import ua.demo.service.jasypt.PropertyServiceForJasyptStarter;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptTest {
    @Autowired
    ApplicationContext appCtx;

    @BeforeClass
    public static void init() {
        System.setProperty("jasypt.encryptor.password", "password");
    }

    @Test
    public void whenDecryptedPasswordNeeded_GetFromService() {
        PropertyServiceForJasyptStarter service = appCtx.getBean(PropertyServiceForJasyptStarter.class);
        assertEquals("Password@1", service.getProperty());
        Environment environment = appCtx.getBean(Environment.class);
        assertEquals("Password@1", service.getPasswordUsingEnvironment(environment));
    }

}
