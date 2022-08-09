package steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.*;

public class BaseSteps {

    protected LoginPage loginPage;

    public void setupScreens(AndroidDriver<MobileElement> driver) {
        loginPage = new LoginPage(driver);
    }

}