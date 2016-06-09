package edu.iis.mto.bdd.cucumber.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.iis.mto.bdd.cucumber.workflowsteps.AuthenticationWorkflowSteps;
import edu.iis.mto.bdd.model.FrequentFlyerMember;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(SerenityRunner.class)
public class UserAuthenticationSteps {
    @Steps
    AuthenticationWorkflowSteps authenticationWorkflowSteps;
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
        authenticationWorkflowSteps.enterEmailAndPassword(frequentFlyerMember);
    }

    @Then("^(.*) should be given access to (?:her|his) account$")
    public void thenTheUserShouldBeGivenAccessToAccount(FrequentFlyerMember frequentFlyerMember) {
        authenticationWorkflowSteps.verifyWelcomeMessageFor(frequentFlyerMember);
    }

    @Given("^(.*) has logged on$")
    public void aUserHasLoggedOnAs(FrequentFlyerMember frequentFlyerMember) {
        authenticationWorkflowSteps.enterEmailAndPassword(frequentFlyerMember);
    }

    @When("^(?:.*) views the home page$")
    public void whenAUserViewsTheHomePage() {
    }

    @After
    public void close() {
        driver.close();
    }

}
