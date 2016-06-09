package edu.iis.mto.bdd.cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

/**
 * Created by piotr on 09.06.16.
 */
@DefaultUrl("http://localhost:8080/#/welcome")
public class HomePage extends PageObject {
    private WebElement email;
    private WebElement password;

    private WebElement signin;

    public void signInWithCredentials(String userMail, String userPassword) {
        email.sendKeys(userMail);
        password.sendKeys(userPassword);
        signin.click();
    }
}
