package edu.iis.mto.bdd.cucumber.workflowsteps;

import edu.iis.mto.bdd.cucumber.pages.HomePage;
import edu.iis.mto.bdd.cucumber.pages.LoginPage;
import edu.iis.mto.bdd.model.FrequentFlyerMember;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by piotr on 09.06.16.
 */
public class AuthenticationWorkflowSteps {
    LoginPage loginPage;
    HomePage homePage;

    @Step
    public void enterEmailAndPassword(FrequentFlyerMember frequentFlyerMember) {
        loginPage.open();
        loginPage.signInWithCredentials(frequentFlyerMember.getEmail(), frequentFlyerMember.getPassword());
    }

    @Step
    public void verifyWelcomeMessageFor(FrequentFlyerMember frequentFlyerMember) {
        String welcomeMessage = homePage.getWelcomeMessage();
        assertThat(welcomeMessage, equalTo("Witaj " + frequentFlyerMember.getFirstName()));
    }
}
