package utils.SetUp.browsers;

import utils.BaseUtils;
import utils.RuntimeProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;

public class BrowserSetUp extends BaseUtils {

    public WebDriver get(BaseUtils base) throws IOException {
        switch (RuntimeProperties.browser) {
            case Chrome:
                PropertiesSetUp.setChrome();
                base.driver = new ChromeDriver();
                break;
            case Firefox:
                PropertiesSetUp.setFirefox();
                base.driver = new FirefoxDriver();
                break;
        }

        return base.driver;
    }

}
