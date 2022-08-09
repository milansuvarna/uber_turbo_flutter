package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.Set;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.appium_flutter_driver.FlutterFinder;

public class BasePage {
    public static AndroidDriver<MobileElement> driver;
    public static void switchContext(String context) {
        driver.getContext();
        Set<String> con = driver.getContextHandles();
        for (String c : con) {
            if (c.contains(context)) {
                driver.context(c);
                break;
            }
        }
    }
    public static WebDriverWait wait;

    public BasePage(AndroidDriver<MobileElement> driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 5);
        switchContext("FLUTTER");
    }
    public void clickValueKey(String element) {
        FlutterFinder flutterFinder = new FlutterFinder(driver);
        flutterFinder.byValueKey(element).click();
    }

    public void clickByText(String element) {
        FlutterFinder flutterFinder = new FlutterFinder(driver);
        flutterFinder.text(element).click();
    }

    public void inputByValueKey(String element,String input) {
        FlutterFinder flutterFinder = new FlutterFinder(driver);
        flutterFinder.byValueKey(element).sendKeys(input);
    }
}