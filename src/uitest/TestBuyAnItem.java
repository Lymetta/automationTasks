import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TestBuyAnItem extends AbstractTest {

    @Test
    public void testBuyAnItem() {
        PageObject page = new PageObject(driver);
        page.login();

        page.clickElement("/html/body/section[2]/div/div/div[2]/div/div[4]/div/div[1]/div[1]/a","xpath");

        page.clickElement("#cartModal > div > div > div.modal-footer > button", "cssSelector");
        page.clickElement("Cart", "linkText");
        page.clickElement("#do_action > div.container > div > div > a", "cssSelector");
        page.waitUntilClickable("#ordermsg > textarea", "cssSelector");
        page.findAndFillForm("#ordermsg > textarea", "Please send as a gift! Thank you!");
        page.clickElement("#cart_items > div > div:nth-child(7) > a", "cssSelector");
        page.waitUntilClickable("#payment-form > div:nth-child(2) > div > input", "cssSelector");
        page.findAndFillForm("#payment-form > div:nth-child(2) > div > input", "Sandra P");
        page.findAndFillForm("#payment-form > div:nth-child(3) > div > input", "1234567890");
        page.findAndFillForm("#payment-form > div:nth-child(4) > div.col-sm-4.form-group.cvc > input", "111");
        page.findAndFillForm("#payment-form > div:nth-child(4) > div:nth-child(2) > input", "02");
        page.findAndFillForm("#payment-form > div:nth-child(4) > div:nth-child(3) > input", "2025");
        page.clickElement("#submit", "cssSelector");
        page.waitUntilClickable("#form > div > div > div > p", "cssSelector");

        assertEquals("Congratulations! Your order has been confirmed!", driver.findElement(By.cssSelector("#form > div > div > div > p")).getText());


    }
}
