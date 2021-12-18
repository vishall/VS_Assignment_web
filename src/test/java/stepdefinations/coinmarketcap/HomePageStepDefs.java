package stepdefinations.coinmarketcap;

import enums.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pageobjects.coinmarketcap.HomePage;
import utils.BaseUtils;
import utils.helpers.SiteUrl;
import java.util.List;


public class HomePageStepDefs {

    private final BaseUtils base;
    private final HomePage homePage;

    public HomePageStepDefs(BaseUtils baseUtil) {
        base = baseUtil;
        homePage = new HomePage(base);
    }

    @Given("^user on the home page$")
    public void user_on_the_home_page() throws Throwable {
        base.loadPage(SiteUrl.url(Environment.TEST));
        base.waitFor(homePage.correctPage, 5);

    }

    @And("user can see 100 results")
    public void user_can_see_100_results() {

        List<WebElement> totalProducts = base.getListOfElements(homePage.allCurrencies);
        Assert.assertEquals("Currency count is less than 100", 100, totalProducts.size());

    }

}
