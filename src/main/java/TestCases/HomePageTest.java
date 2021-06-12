package TestCases;

import Collections.HomePageCollections;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePageTest {

    private final WebDriver  driver;

    public HomePageTest() {
        this.driver = DriverSetup.driver;
    }

    By signInButton = By.cssSelector("div.header_user_info");
    By homePagePopularTextElement = By.className("homefeatured");
    By dressesTab = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a");
    By summerDressesTab = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(3) > a");
    By cartButton = By.cssSelector("div:nth-child(3) > div > a");
    By myProfileButton = By.className("account");

    @When("Navigate to automationPractice homepage URL")
    public void navigateToHomePage(){
        driver.get(HomePageCollections.homePageUrl);
    }

    @And("Click to signIn button")
    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }

    @Then("Homepage successfully loaded")
    public void homePageSuccessLoad(){
        Assert.assertEquals(driver.findElement(homePagePopularTextElement).getText(),HomePageCollections.popularText);
    }

    @And("I'm clicking SummerDress Tab")
    public void iClickingSummerDressTab(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(dressesTab)).
                moveToElement(driver.findElement(summerDressesTab))
        .click().build().perform();
    }

    @And("I'm clicking Cart button")
    public void iClickingCartButton(){
        driver.findElement(cartButton).click();

    }

    @And("I'm clicking My Account Button")
    public void iClickingMyProfileButton(){
        driver.findElement(myProfileButton).click();
    }

}
