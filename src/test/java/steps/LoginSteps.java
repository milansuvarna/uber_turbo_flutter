package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.ThreadLocalDriver;

public class LoginSteps extends BaseSteps {

    @Before
    public void setupLoginSteps() {
        setupScreens(ThreadLocalDriver.getTLDriver());
    }

    @Given("Borrower on Welcome screen")
    public void borrowerOnWeclomeScreen() throws InterruptedException {
        loginPage.clickLoginWithEmailButton();
        loginPage.inputEmail("997");
        loginPage.inputPassword("Test997");
        loginPage.clickContinueButton();
    }

    @When("Borrower login with valid credential")
    public void loginWithValidCredential() throws InterruptedException {
        loginPage.clickLoginWithEmailButton();
        loginPage.inputEmail("997");
        loginPage.inputPassword("Test997");
        loginPage.clickContinueButton();
    }

    @Then("Borrower successfully login")
    public void borrowerSuccessfullyLogin() throws InterruptedException {
        loginPage.clickLoginWithEmailButton();
        loginPage.inputEmail("997");
        loginPage.inputPassword("Test997");
        loginPage.clickContinueButton();
    }
}

