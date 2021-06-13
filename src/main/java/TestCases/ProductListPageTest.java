package TestCases;

import Collections.ProductListPageCollections;
import Utilies.DriwerWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class ProductListPageTest {

    public ProductListPageTest() {
        this.driver = DriverSetup.driver;
    }

    private final WebDriver driver;

    public static ArrayList<String> addedToCartProductListName = new ArrayList<String>();

    By catalogTextElement = By.cssSelector("#layered_block_left > p");
    By listedProductsElement = By.className("product-container");
    By addCartButtonElement = By.cssSelector("a.button.ajax_add_to_cart_button.btn.btn-default > span");
    By addedProductSuccessIconElement = By.className("icon-ok");
    By addedProductInChartTextElement = By.id("layer_cart_product_title");
    By continueShoppingElement = By.cssSelector("div.button-container > span");
    By searchTextAreaElement = By.id("search_query_top");
    By searchButtonElement = By.cssSelector("#searchbox > button");
    By searchResultTextElement = By.className("lighter");

    @Then("Product List page successfully loaded")
    public void productListPageSuccessfullyLoaded(){
        DriwerWait.driverWaitExpectedConditions(driver,catalogTextElement);
        Assert.assertEquals(driver.findElement(catalogTextElement).getText(), ProductListPageCollections.catalogText);
    }

    @And("I'm adding to chart any product")
    public void iAddingToChartAnyProduct(){
        List<WebElement> listedProducts = driver.findElements(listedProductsElement);
        List<WebElement> addCartButtons = driver.findElements(addCartButtonElement);

        Actions actions = new Actions(driver);
        actions.moveToElement(listedProducts.get(1)).moveToElement(addCartButtons.get(1)).click().build().perform();
    }

    @Then("Product is successfully added to your shopping chart")
    public void productSuccessfullyAddedToChart(){
        Assert.assertNotNull(driver.findElement(addedProductSuccessIconElement));
        DriwerWait.driverWaitExpectedConditions(driver,addedProductInChartTextElement);
        addedToCartProductListName.add(driver.findElement(addedProductInChartTextElement).getText());
    }

    @And("I'm clicking continue shopping button at cart view")
    public void iClickingContinueShoppingButton(){
        DriwerWait.driverWaitExpectedConditions(driver,continueShoppingElement);
        driver.findElement(continueShoppingElement).click();
    }

    @When("I'm filling search text area")
    public void iFillingSearchTextArea(){
        driver.findElement(searchTextAreaElement).sendKeys(ProductListPageCollections.searchText);
    }

    @And("I'm clicking search button")
    public void iClickingSearchButton(){
        driver.findElement(searchButtonElement).click();
    }

    @Then("Search is successfully")
    public void isSearchSuccessful(){
        Assert.assertEquals(driver.findElement(searchResultTextElement).getText(),ProductListPageCollections.expectedSearchText);
    }

}
