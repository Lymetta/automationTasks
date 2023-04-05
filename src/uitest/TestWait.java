import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TestWait extends AbstractTest {

    @Test
    public void testWait() {
        PageObject page = new PageObject(driver);

        page.clickElement("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.productinfo.text-center > a","cssSelector");

        page.clickElement("#cartModal > div > div > div.modal-footer > button", "cssSelector");
        page.clickElement("Cart", "linkText");
        assertEquals("Blue Top", driver.findElement(By.cssSelector("#product-1 > td.cart_description > h4 > a")).getText());

    }
}
