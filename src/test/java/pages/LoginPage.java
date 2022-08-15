package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;

public class LoginPage extends BasePage {
    public LoginPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    /**Elements**/
    String email_button = "emailLoginKey";
    String login_text = "Log in";
    String username_textfield = "txtField_username";
    String password_textfield = "txtField_password";
    String continue_button = "Continue";


    /**Actions**/
    public void clickLoginWithEmailButton() {
        clickByText(login_text);
        clickValueKey(email_button);
    }

    public void inputEmail(String input) {
        clickValueKey(username_textfield);
        inputByValueKey(username_textfield,input);
    }

    public void inputPassword(String input) {
        clickValueKey(password_textfield);
        inputByValueKey(password_textfield,input);
    }
    @SneakyThrows
    public void clickContinueButton() {
        clickByText(continue_button);
    }
}

