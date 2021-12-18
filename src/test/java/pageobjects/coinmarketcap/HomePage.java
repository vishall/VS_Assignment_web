package pageobjects.coinmarketcap;

import utils.BasePageObject;
import utils.BaseUtils;
import org.openqa.selenium.By;

public class HomePage extends BasePageObject {

    public HomePage(BaseUtils base){super(base); }

    public By correctPage = By.id("__next");
    public By allCurrencies = By.cssSelector("table.h7vnx2-2 > tbody > tr");

}
