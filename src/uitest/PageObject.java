import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

    WebDriver driver;


    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(String selector, String type){
        if(type.equals("linkText")){
            waitUntilClickable(selector, "linkText");
            driver.findElement(By.linkText(selector)).click();
        }else if(type.equals("cssSelector")){
            waitUntilClickable(selector, "cssSelector");
            driver.findElement(By.cssSelector(selector)).click();
        }

    }

    public void findAndFillForm (String selector, String value){

        driver.findElement(By.cssSelector(selector)).sendKeys(value);
    }

    public void waitUntilClickable (String element, String type){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        if (type.equals("linkText")){
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText(element)));
        }else if(type.equals("cssSelector"))
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(element)));
        };


    }

    public void goToContactForm(){
        clickElement("Contact us", "linkText");

    }

    public void fillContactForm(){
        waitUntilClickable("#contact-us-form > div:nth-child(2) > input", "cssSelector");

        findAndFillForm("#contact-us-form > div:nth-child(2) > input", "Sandra");
        findAndFillForm("#contact-us-form > div:nth-child(3) > input", "Proch@gmail.com");
        findAndFillForm("#contact-us-form > div:nth-child(4) > input", "Love this page!");
        findAndFillForm("#message", "Hello! I love this page!!!");

    }

    public void login (){
        clickElement("Signup / Login", "linkText");
        waitUntilClickable("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)", "cssSelector");
        findAndFillForm("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)", "emails@email");
        findAndFillForm("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)", "password");
        clickElement("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button", "cssSelector");
    }
}
