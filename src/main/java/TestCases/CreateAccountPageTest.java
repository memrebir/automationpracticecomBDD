package TestCases;

import Collections.CreateAccountPageCollections;
import Utilies.DriwerWait;
import Utilies.RandomCreator;
import Utilies.SelectList;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPageTest {

    private final WebDriver  driver;

    public CreateAccountPageTest() {
        this.driver = DriverSetup.driver;
    }

    public static String firstName = RandomCreator.randomNameCreator(7);
    public static String lastName = RandomCreator.randomNameCreator(5);
    public static String password = RandomCreator.randomPasswordCreator(8);

    By genderMrCheckBox = By.id("uniform-id_gender1");
    By customerFirstNameTextBox = By.id("customer_firstname");
    By customerLastNameTextBox = By.id("customer_lastname");
    By passwordTextBox = By.id("passwd");
    By addressFirstNameTextBox = By.id("firstname");
    By addressLastNameTextBox = By.id("lastname");
    By address1TextBox = By.id("address1");
    By addressCityTextBox = By.id("city");
    By addressPostalCodeTextBox = By.id("postcode");
    By addressPhoneTextBox = By.id("phone_mobile");
    By registerButton = By.id("submitAccount");
    By welcomeYourAccountTextElement = By.className("info-account");

    @Given("Navigate to automationPractice createAnAccount page")
    public void navigateToCreateAnAccountPage(){
        driver.get(CreateAccountPageCollections.createAccountPageUrl);
    }

    @And("I'm filling personal information areas")
    public void iFillingPersonalInformationAreas(){
        DriwerWait.driverWaitExpectedConditions(driver,By.id("uniform-id_gender1"));
        driver.findElement(genderMrCheckBox).click();
        driver.findElement(customerFirstNameTextBox).sendKeys(firstName);
        driver.findElement(customerLastNameTextBox).sendKeys(lastName);
        driver.findElement(passwordTextBox).sendKeys(password);
        SelectList.selectedItemToSelectList(driver,"days", 13);
        SelectList.selectedItemToSelectList(driver,"months", 1);
        SelectList.selectedItemToSelectList(driver,"years", 25);
    }

    @And("I'm filling your address areas")
    public void iFillingYourAddressAreas(){
        driver.findElement(addressFirstNameTextBox).sendKeys(firstName);
        driver.findElement(addressLastNameTextBox).sendKeys(lastName);
        driver.findElement(address1TextBox).sendKeys(CreateAccountPageCollections.addressText);
        driver.findElement(addressCityTextBox).sendKeys(CreateAccountPageCollections.addressCityText);
        SelectList.selectedItemToSelectList(driver,"id_state",5);
        driver.findElement(addressPostalCodeTextBox).sendKeys(CreateAccountPageCollections.addressPostalCodeText);
        SelectList.selectedItemToSelectList(driver,"id_country", 1);
        driver.findElement(addressPhoneTextBox).sendKeys(CreateAccountPageCollections.mobilePhone);
    }

    @And("I'm clicking register button")
    public void iClickingRegisterButton(){
        driver.findElement(registerButton).click();
    }

    @Then("Account successfully created")
    public void accountSuccessfullyCreated(){
        Assert.assertEquals(driver.findElement(welcomeYourAccountTextElement).getText(),CreateAccountPageCollections.welcomeYourAccountText);
    }




}
