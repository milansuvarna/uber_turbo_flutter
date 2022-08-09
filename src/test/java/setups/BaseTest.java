package setups;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import util.Capabilities;
import util.ThreadLocalDriver;

import java.io.IOException;
import java.net.URL;

public class BaseTest {
    private final Capabilities desiredCapabilitiesUtil = new Capabilities();

    @BeforeMethod
    @Parameters({ "udid", "platformVersion" })
    public void setup(String udid, String platformVersion) throws IOException {
        DesiredCapabilities capabilities = desiredCapabilitiesUtil.getDesiredCapabilities(udid, platformVersion);
        ThreadLocalDriver.setTLDriver(new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
    }

    @AfterMethod
    public synchronized void teardown() {
        ThreadLocalDriver.getTLDriver().quit();
    }
}
