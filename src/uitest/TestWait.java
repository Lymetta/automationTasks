import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TestWait extends AbstractTest {

    @Test
    public void testWait() {
        PageObject page = new PageObject(driver);

        page.clickElement("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a","xpath");

        page.clickElement("#cartModal > div > div > div.modal-footer > button", "cssSelector");
        page.clickElement("Cart", "linkText");
        assertEquals("Blue Top", driver.findElement(By.cssSelector("#product-1 > td.cart_description > h4 > a")).getText());

    }
}
