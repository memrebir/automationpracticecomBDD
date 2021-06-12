package TestCases;

import Collections.SignInPageCollections;
import Utilies.DriwerWait;
import Utilies.RandomCreator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPageTest {

    public SignInPageTest() { this.driver = DriverSetup.driver; }

    private final WebDriver  driver;

    public static String randomEmail = RandomCreator.randomEmailCreator();

    By validEmailIcon = By.cssSelector("div.form-group.form-ok");
    By emailBoxElement = By.id("email_create");
    By forRandomClickElement = By.className("page-subheading");
    By emailValidIconElement = By.cssSelector("div.form-group.form-ok");
    By createAccountElement = By.id("SubmitCreate");


    @Given("Navigate to automationPractice authenticationPage page")
    public void navigateToAuthenticationPage(){
        driver.get(SignInPageCollections.signInPageUrl);
    }

    @And("I'm filling valid email address at Create an account menu")
    public void iFilingEmailAddressBox(){
        driver.findElement(emailBoxElement).sendKeys(randomEmail);
        driver.findElement(forRandomClickElement).click(); // random click for show success icon for valid email
        DriwerWait.driverWaitExpectedConditions(driver,validEmailIcon);
    }

    @And("I click create an account button")
    public void iClickCreteAnAccountButton(){
        if(driver.findElement(emailValidIconElement).isDisplayed()){
            driver.findElement(createAccountElement).click();
        }
        else
            Assert.fail("Email address is not valid");
    }

    @Then("Is the entered email valid?")
    public void isTheEnteredEmailValid(){
        Assert.assertNotNull(driver.findElement(emailValidIconElement));
    }


}
