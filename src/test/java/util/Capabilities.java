package util;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;


public class Capabilities {
    public static String appPtah = "/src/test/resources/app/test.apk";
    public DesiredCapabilities getDesiredCapabilities(String udid, String platformVersion) {
        DesiredCapabilities flutterCapabilities = new DesiredCapabilities();
        File rootFile = new File("");
        File appFile = new File(rootFile.getAbsolutePath() + appPtah);
        appPtah = appFile.getAbsolutePath();
        flutterCapabilities.setCapability("app",appPtah);
        flutterCapabilities.setCapability("udid", udid);
        flutterCapabilities.setCapability("platformName", "Android");
        flutterCapabilities.setCapability("platformVersion", platformVersion);
        flutterCapabilities.setCapability("automationName", "Flutter");
        flutterCapabilities.setCapability("autoGrantPermissions", "true");
        flutterCapabilities.setCapability("skipUnlock", "true");
        flutterCapabilities.setCapability("noReset", "false");
        return flutterCapabilities;
    }
}
