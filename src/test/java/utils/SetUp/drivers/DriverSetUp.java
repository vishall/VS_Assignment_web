package utils.SetUp.drivers;

import utils.BaseUtils;
import utils.SetUp.browsers.BrowserSetUp;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class DriverSetUp
{

    public WebDriver getDriver(BaseUtils base) throws IOException
    {
        BrowserSetUp bs = new BrowserSetUp();
        base.driver = bs.get(base);
        return base.driver;
    }

    public WebDriver get(BaseUtils base) throws IOException
    {
        WebDriver driver;
        driver = new DriverSetUp().getDriver(base);
        return driver;
    }
}

