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

    @When("user login with valid credential")
    public void loginWithValidCredential() throws InterruptedException {
        loginPage.clickLoginWithEmailButton();
        loginPage.inputEmail("997");
        loginPage.inputPassword("Test997");
        loginPage.clickContinueButton();
    }
}

