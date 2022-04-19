package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class LoginTest extends BaseTest {

    //Declaring URL

    String baseUrl = "https://www.saucedemo.com/";

    //Setting up the browser before each individual test
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Enter “standard_user” username
        WebElement enterUsername = driver.findElement(By.id("user-name"));
        enterUsername.sendKeys("standard_user");

        //Enter “secret_sauce” password
        WebElement enterPassword = driver.findElement(By.id("password"));
        enterPassword.sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        WebElement clickLoginBtn = driver.findElement(By.id("login-button"));
        clickLoginBtn.click();

        //Verify the text “PRODUCTS”
        //Declaring the text from the requirements
        String expectedMessage = "PRODUCTS";

        //Find the "PRODUCTS” text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        //Validate actual and expected message
        Assert.assertEquals("The program hasn't navigated to the next page successfully", actualMessage, expectedMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //Enter “standard_user” username
        WebElement enterUsername = driver.findElement(By.id("user-name"));
        enterUsername.sendKeys("standard_user");

        //Enter “secret_sauce” password
        WebElement enterPassword = driver.findElement(By.id("password"));
        enterPassword.sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        WebElement clickLoginBtn = driver.findElement(By.id("login-button"));
        clickLoginBtn.click();

        //Verify that six products are displayed on page
        //Declaring the number of items from the requirements
        int expectedResult = 6;

        //Find the "PRODUCTS” text element and get the text
        List<WebElement> items = driver.findElements(By.className("inventory_item"));
        int list = items.size();

        //Validate actual and expected message
        Assert.assertEquals("Number of items listed doesn't match amount that should be listed", list, expectedResult);
    }

    //Closing the browser after each individual test
    @After
    public void tearDown() {
        closeBrowser();
    }

}
