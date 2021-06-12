package TestCases;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class DriverSetup {

    public static WebDriver driver;

    @Given("Start Driver and Browser")
    public void setUp(){
        setProperty();
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public static void setProperty(){

        Properties properties = System.getProperties();
        System.setProperty("webdriver.chrome.driver", properties.getProperty("user.dir") + "//drivers//chromedriver");
        //System.setProperty("webdriver.chrome.driver", properties.getProperty("user.dir") + "//drivers//chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", properties.getProperty("user.dir") + "//drivers//geckodriver");
        //System.setProperty("webdriver.gecko.driver", properties.getProperty("user.dir") + "//drivers//geckodriver.exe");
    }
}
