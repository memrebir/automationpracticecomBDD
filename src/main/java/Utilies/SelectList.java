package Utilies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectList {


    public static void selectedItemToSelectList(WebDriver driver, String elementId, int index){
        Select dropdown = new Select(driver.findElement(By.id(elementId)));
        dropdown.selectByIndex(index);

    }
}
