import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class FormTest extends AbstractTest {



    @Test
    public void testContactUsForm() throws InterruptedException {
        driver.findElement(By.linkText("Contact us")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#contact-us-form > div:nth-child(2) > input")));

        driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(2) > input")).sendKeys("Sandra");
        driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(3) > input")).sendKeys("Proch@gmail.com");
        driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(4) > input")).sendKeys("Love this page!");
        driver.findElement(By.id("message")).sendKeys("Hello! I love this page!!!");

        Thread.sleep(500);

        driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(7) > input")).click();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();


        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success")));

        WebElement actual = driver.findElement(By.cssSelector("#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success"));
        //#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success

        assertEquals ("Success! Your details have been submitted successfully.", actual.getText());

    }
}
