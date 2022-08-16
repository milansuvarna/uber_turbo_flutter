package setups;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import util.Capabilities;
import util.ThreadLocalDriver;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class BaseTest {
    public String jsonConfig;
    public String serverUrl;

    @BeforeMethod(alwaysRun = true)
    @Parameters(value = {"server"})
    public void setUp(String type) throws Exception {
        if (type.equals("browserstack")) {
            jsonConfig = "src/test/resources/browserstack.conf.json";
        } else if (type.equals("local")) {
            jsonConfig = "src/test/resources/local.conf.json";
        }
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader(jsonConfig));
        JSONArray envs = (JSONArray) config.get("environments");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(0);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (capabilities.getCapability(pair.getKey().toString()) == null) {
                capabilities.setCapability(pair.getKey().toString(), pair.getValue());
            }
        }

        String username = (String) config.get("username");
        String accessKey = (String) config.get("access_key");
        String server = (String) config.get("server");
        String app = System.getenv("BROWSERSTACK_APP_ID");
        if (app != null && !app.isEmpty()) {
            capabilities.setCapability("app", app);
        }

        if (username == null && accessKey == null && server == null) {
            serverUrl = "http://127.0.0.1:4723/wd/hub";
        } else {
            serverUrl = "http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub";
        }

        ThreadLocalDriver.setTLDriver(new AndroidDriver<MobileElement>(new URL(serverUrl), capabilities));
    }

    @AfterMethod(alwaysRun = true)
    public synchronized void teardown() {
        ThreadLocalDriver.getTLDriver().quit();
    }
}
