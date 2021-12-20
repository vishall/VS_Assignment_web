package stepdefinations.coinmarketcap;

import enums.Conditions;
import enums.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pageobjects.coinmarketcap.HomePage;
import utils.BaseUtils;
import utils.RuntimeProperties;
import utils.builders.WFBuilder;
import utils.helpers.SiteUrl;

import java.util.ArrayList;
import java.util.List;


public class HomePageStepDefs {

    private final BaseUtils base;
    private final HomePage homePage;
    List<String> dataWithPreselectedDateRange = new ArrayList<>();
    List<String> dataWithUserSelectedDateRange = new ArrayList<>();

    public HomePageStepDefs(BaseUtils baseUtil) {
        base = baseUtil;
        homePage = new HomePage(base);
    }

    @Given("^user on the home page$")
    public void user_on_the_home_page() throws Throwable {
        base.loadPage(SiteUrl.url(Environment.TEST));
        base.waitFor(homePage.correctPage, 5);

    }

    @And("^user can see (\\d+) results for various cryptos$")
    public void user_can_see_100_results_for_various_cryptos(int resultCount) {

        List<WebElement> totalProducts = base.getListOfElements(homePage.allCurrencies);
        Assert.assertEquals("Cryptocurrency result count doesn't match", resultCount, totalProducts.size());

    }

    @And("user clicks on login link")
    public void user_clicks_on_login_link() {
        base.waitFor(homePage.clickOnLogIn).click();

    }

    @And("user enters username and password")
    public void user_enters_username() {
        System.out.println(RuntimeProperties.username);
        base.clickInsert(homePage.usernameTextBox, RuntimeProperties.username);
        base.clickInsert(homePage.passwordTextBox, RuntimeProperties.password);
    }

    @And("user clicks on login button")
    public void user_clicks_on_login_button() {

        base.waitFor(homePage.loginButton).click();
    }

    @And("user should complete slide in captcha")
    public void user_should_complete_slide_in_captcha() {
        base.waitFor(homePage.captchaScreen, WFBuilder.options().conditions(Conditions.CLICKABLE).build());
        base.waitFor(homePage.captchaScreen, 10000);
        WebElement slider = base.driver.findElement(homePage.slider);
        Actions move = new Actions(base.driver);
        Action action = move.dragAndDropBy(slider, 90, 0).build();
        action.perform();
    }

    @Then("user should be able to login successfully")
    public void user_should_be_able_to_login_successfully() {

    }

    @And("user should add some cryptocurrencies to the watchlist")
    public void user_should_add_some_cryptocurrencies_to_the_watchlist() {

    }

    @And("user open the watchlist in different browser window")
    public void user_open_the_watchlist_in_different_browser_window() {

    }

    @When("user clicks on the watchlist tab")
    public void user_clicks_on_the_watchlist_tab() {

    }

    @Then("user verify all the selected options are added to the watchlist")
    public void user_verify_all_the_selected_options_are_added_to_the_watchlist() {

    }

    @And("user select the historical data for one of the cryptocurrency")
    public void user_select_the_historical_data_for_one_of_the_cryptocurrency() {
        JavascriptExecutor jse = (JavascriptExecutor) base.driver;
        jse.executeScript("window.scrollBy(0,500)");
        WebElement dropdownOption = base.driver.findElement(homePage.dropdownMenu);
        dropdownOption.click();
        WebElement historicalDataLink = base.driver.findElement(homePage.historicalData);
        base.waitFor(homePage.historicalData, WFBuilder.options().conditions(Conditions.CLICKABLE).build());
        historicalDataLink.click();
    }

    @When("user record the current data for selected date range")
    public void user_record_the_current_data_for_selected_date_range() {
        JavascriptExecutor jse = (JavascriptExecutor) base.driver;
        jse.executeScript("window.scrollBy(0,500)");
        List<WebElement> allHistoricalData = base.getListOfElements(homePage.allHistoricalDataTable);
        for (int i = 0; i < allHistoricalData.size(); i++) {
            String historicData = allHistoricalData.get(i).getText();
            dataWithPreselectedDateRange.add(historicData);
        }
    }

    @And("user change the date range from the date filter")
    public void user_change_the_date_range_from_the_date_filter() {
        base.waitFor(homePage.dateRangeFilter).click();
        base.waitFor(homePage.selectDateRangeSevenDays).click();
        base.waitFor(homePage.continueButton).click();
        base.waitFor(homePage.dateRangeFilter).click();

    }

    @Then("user verify result against preselected historical data")
    public void user_verify_result_against_preselected_historical_data() {

        JavascriptExecutor jse = (JavascriptExecutor) base.driver;
        jse.executeScript("window.scrollBy(0,500)");
        List<WebElement> newHistoricalData = base.getListOfElements(homePage.allHistoricalDataTable);
        for (int i = 0; i < newHistoricalData.size(); i++) {
            String currentHistoricData = newHistoricalData.get(i).getText();
            dataWithUserSelectedDateRange.add(currentHistoricData);
        }
        Assert.assertTrue("Historical data from the custom filter is not present in the preselected data", dataWithPreselectedDateRange.containsAll(dataWithUserSelectedDateRange));
    }
}
