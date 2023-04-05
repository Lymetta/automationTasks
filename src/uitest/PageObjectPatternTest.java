import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class PageObjectPatternTest extends AbstractTest {

    @Test
    public void testContactUsForm() throws InterruptedException {

        PageObject page = new PageObject(driver);
        page.goToContactForm();
        page.fillContactForm();
        page.clickElement("#contact-us-form > div:nth-child(7) > input", "cssSelector");
        driver.switchTo().alert().accept();
        page.waitUntilClickable("#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success", "cssSelector");

        assertEquals("Success! Your details have been submitted successfully.",
                driver.findElement(By.cssSelector("#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success")).getText());

    }
}
