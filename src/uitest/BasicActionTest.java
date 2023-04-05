import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class BasicActionTest extends AbstractTest {

    @Test
    public void testPageTitle() {
        driver.findElement(By.linkText("Contact us")).click();
        assertEquals("https://automationexercise.com/contact_us", driver.getCurrentUrl());
    }
}
