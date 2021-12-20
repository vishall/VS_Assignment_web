package pageobjects.coinmarketcap;

import org.openqa.selenium.By;
import utils.BasePageObject;
import utils.BaseUtils;

public class HomePage extends BasePageObject {

    public By correctPage = By.id("__next");
    public By allCurrencies = By.cssSelector("table.h7vnx2-2 > tbody > tr");
    public By allHistoricalDataTable = By.cssSelector("table > tbody > tr");
    public By clickOnLogIn = By.cssSelector("div.sc-111rrsy-0.qbrWo > button.x0o17e-0.qrNYy");
    public By usernameTextBox = By.cssSelector("body > div.t8xka3-0.clxZon.modalOpened > div > div > div > div:nth-child(3) > input");
    public By passwordTextBox = By.cssSelector("div.sc-1srpo52-0.ciHfxX > input");
    public By loginButton = By.cssSelector("div.sc-1htht4q-6.kUXNCx > button");
    public By captchaScreen = By.cssSelector("body > div.css-fbfbbj > div");
    public By slider = By.cssSelector("div.css-p72bjc > div");
    public By dropdownMenu = By.cssSelector("table > tbody > tr:nth-child(1) > td:nth-child(11) > div > button > span");
    public By historicalData = By.cssSelector("#tippy-9 > div > div.tippy-content > div > div > a:nth-child(3) > button");
    public By dateRangeFilter = By.cssSelector("div.sc-6azhez-0.dpJAWF > span > button");
    public By selectDateRangeSevenDays = By.cssSelector("div.yzncs8-4.jaVFYH > ul > li:nth-child(1)");
    public By continueButton = By.cssSelector("div.yzncs8-2.keWhlt > span > button");

    public HomePage(BaseUtils base) {
        super(base);
    }
}
