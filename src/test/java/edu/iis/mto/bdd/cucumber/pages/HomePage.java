package edu.iis.mto.bdd.cucumber.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

/**
 * Created by piotr on 09.06.16.
 */
public class HomePage extends PageObject {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectMenuOptions(String... menuOptions) {
        for (String menuChoice : menuOptions) {
            $(".mainMenu").findBy(By.linkText(menuChoice)).click();
        }
    }
}
