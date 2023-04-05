import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TestAddToCard extends AbstractTest {

    @Test
    public void testAddToCard() {
       PageObject page = new PageObject(driver);
       page.clickElement("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a","cssSelector");
       page.waitUntilClickable("#search_product","cssSelector");
       page.findAndFillForm("#search_product", "shirt");
       page.clickElement("#submit_search", "cssSelector");


       page.clickElement("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.single-products > div.productinfo.text-center > a",
               "cssSelector");
       page.clickElement("#cartModal > div > div > div.modal-footer > button", "cssSelector");
       page.clickElement("Cart", "linkText");

       assertEquals("Men Tshirt", driver.findElement(By.cssSelector("#product-2 > td.cart_description > h4 > a")).getText());


    }
}
