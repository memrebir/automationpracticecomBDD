package TestCases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPageTest {

    private final WebDriver driver;
    public MyAccountPageTest() {
        this.driver = DriverSetup.driver;
    }

    By orderHistoryAndDetailsButton = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a");
    By orderListReferenceCodeTextElement = By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a");

    @And("I'm clicking order history and details")
    public void iClickingOrderHistoryAndDetailsButton(){
        driver.findElement(orderHistoryAndDetailsButton).click();
    }

    @Then("Order history order list control")
    public void orderHistoryOrderListControl(){
        Assert.assertEquals(driver.findElement(orderListReferenceCodeTextElement).getText(),CartPage.orderReference);
    }
}
