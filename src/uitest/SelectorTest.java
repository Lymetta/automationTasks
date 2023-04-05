import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SelectorTest extends AbstractTest {

    @Test
    public void testSignInText() {

        WebElement signInText  = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        assertEquals("Signup / Login", signInText.getText());


    }

    @Test
    public void testFindLastProductAndVerifyPrice() throws InterruptedException {

        WebElement actual = driver.findElement(By.xpath("//h2[contains(text(), 'Rs. 1389')]"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", actual);
        Thread.sleep(500);
        assertEquals("Rs. 1389", actual.getText() );

    }

    @Test
    public void testFindContactEmailAndVerifyValue(){
        driver.findElement(By.linkText("Contact us")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'feedback@automationexercise.com')]")));

        WebElement actual = driver.findElement(By.xpath("//*[contains(text(), 'feedback@automationexercise.com')]"));

        assertEquals("feedback@automationexercise.com", actual.getText());
    }
}
