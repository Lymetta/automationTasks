import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSignIn extends AbstractTest {

    @Test
    public void testSignIn() throws InterruptedException {
        PageObject page = new PageObject(driver);
        page.login();

       Thread.sleep(1000);

        assertEquals("https://automationexercise.com/", driver.getCurrentUrl());
    }
}
