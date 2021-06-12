package TestCases;

import Collections.CartPageCollections;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class CartPage {

    private final WebDriver driver;

    public static ArrayList<String> productNameListInCart = new ArrayList<String>();
    public static String orderReference = null;

    By yourShoppingCartNavigation = By.className("navigation_page");
    By proceedToCheckOutButtonCartPage = By.cssSelector("a.button.btn.btn-default.standard-checkout.button-medium");
    By chartProductList = By.cssSelector("td.cart_description > p > a");
    By proceedToCheckOutButtonAddressPage = By.cssSelector("#center_column > form > p > button");
    By checkingTermsCheckBox = By.id("cgv");
    By proceedToCheckOutButtonShippingPage = By.cssSelector("#form > p > button");
    By payByBankWireOptionButton = By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a");
    By confirmOrderButton = By.cssSelector("#cart_navigation > button");
    By orderIsCompleteTextElement = By.cssSelector("#center_column > div > p > strong");
    By orderIsCompleteAllTextElement = By.cssSelector("#center_column > div");


    public CartPage() {
        this.driver = DriverSetup.driver;
    }

    @Then("Cart page is successfully loaded")
    public void isChartPageSuccessfullyLoaded(){
        Assert.assertEquals(driver.findElement(yourShoppingCartNavigation).getText(),
                CartPageCollections.yourShoppingCartNavigationText);
    }

    @And("I'm clicking proceed to checkout button at cart page")
    public void iClickingProceedToCheckOut(){
        driver.findElement(proceedToCheckOutButtonCartPage).click();
    }

    @Then("Are the products the ones I added?")
    public void areTheProductsTheOnesIAdded(){
        productNameListInCart.add(driver.findElement(chartProductList).getText());
        for (int i = 0; i< productNameListInCart.size(); i++){
            Assert.assertEquals(ProductListPageTest.addedToCartProductListName.get(i),productNameListInCart.get(i));
        }
    }

    @And("I'm clicking proceed the checkout button at address page")
    public void iClickingProceedTheCheckoutButtonAtAddressPAge(){
        driver.findElement(proceedToCheckOutButtonAddressPage).click();
    }

    @When("I'm checking terms of service checkbox")
    public void iCheckingTermsOfServiceCheckbox(){
        driver.findElement(checkingTermsCheckBox).click();
    }

    @And("I'm clicking proceed the checkout button at shipping page")
    public void iClickingProceedTheCheckoutButtonShippingPage(){
        driver.findElement(proceedToCheckOutButtonShippingPage).click();
    }

    @And("I'm clicking PayByBankWire option")
    public void iClickingPayByBankWireOption(){
        driver.findElement(payByBankWireOptionButton).click();
    }

    @And("I'm clicking I Confirm Order Button")
    public void iClickingIConfirmOrderButton(){
        driver.findElement(confirmOrderButton).click();
    }

    @Then("Is My Order Complete?")
    public void isMyOrderComplete(){
        Assert.assertEquals(driver.findElement(orderIsCompleteTextElement).getText(),
                CartPageCollections.orderIsCompleteText);
        orderReference = driver.findElement(orderIsCompleteAllTextElement).
                getAttribute("innerText").substring(217,226);
    }

}
