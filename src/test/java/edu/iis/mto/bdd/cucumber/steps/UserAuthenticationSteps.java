package edu.iis.mto.bdd.cucumber.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.iis.mto.bdd.model.FrequentFlyerMember;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class UserAuthenticationSteps {
    private WebDriver driver;

    @Before
    public void init() {
        driver = new FirefoxDriver();
    }

    @Given("^(.*) is a registered Frequent Flyer$")
    public void givenARegisteredFrequentFlyer(FrequentFlyerMember frequentFlyerMember) {
    }

    @When("^(.*) authenticates with a valid email address and password$")
    public void whenJaneAuthenticatesWithAValidEmailAddressAndPassword(FrequentFlyerMember frequentFlyerMember) {
        driver.get("http://localhost:8080/#/welcome");
        driver.findElement(By.name("email")).sendKeys(frequentFlyerMember.getEmail());
        driver.findElement(By.name("password")).sendKeys(frequentFlyerMember.getPassword());
        driver.findElement(By.name("signin")).click();
    }

    @Then("^(.*) should be given access to (?:her|his) account$")
    public void thenTheUserShouldBeGivenAccessToAccount(FrequentFlyerMember frequentFlyerMember) {
        assertThat(driver.findElement(By.id("welcome-message")).getText(), equalTo("Witaj " + frequentFlyerMember.getFirstName()));
    }

    @Given("^(.*) has logged on$")
    public void aUserHasLoggedOnAs(FrequentFlyerMember frequentFlyerMember) {
        driver.get("http://localhost:8080/#/welcome");
        driver.findElement(By.name("email")).sendKeys(frequentFlyerMember.getEmail());
        driver.findElement(By.name("password")).sendKeys(frequentFlyerMember.getPassword());
        driver.findElement(By.name("signin")).click();
    }

    @When("^(?:.*) views the home page$")
    public void whenAUserViewsTheHomePage() {
    }

    @After
    public void close() {
        driver.close();
    }

}
