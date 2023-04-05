import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TestAddToCard extends AbstractTest {

    @Test
    public void testAddToCard() throws InterruptedException {
        PageObject page = new PageObject(driver);
        page.clickElement("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a", "cssSelector");
        page.waitUntilClickable("#search_product", "cssSelector");
        page.findAndFillForm("#search_product", "shirt");
        page.clickElement("#submit_search", "cssSelector");
        Thread.sleep(1000);
        page.clickElement("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a",
                "xpath");
        page.clickElement("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button", "cssSelector");
        page.clickElement("#cartModal > div > div > div.modal-footer > button", "cssSelector");
        page.clickElement("Cart", "linkText");

        assertEquals("Men Tshirt", driver.findElement(By.cssSelector("#product-2 > td.cart_description > h4 > a")).getText());


    }
}
