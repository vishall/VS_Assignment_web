package utils;

import enums.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.builders.WFBuilder;

import java.util.List;

public class BaseUtils extends State {

    public void loadPage(String url) {
        driver.get(url);
    }

    public WebElement waitFor(By locator, int timeout) {
        return waitFor(locator, WFBuilder.options().timeoutSeconds(timeout).build());
    }

    public WebElement waitFor(By locator, WFBuilder options) {
        WebElement element = null;
        Exception exception = null;
        try {
            switch (options.conditions) {
                case CLICKABLE:
                    element = new WebDriverWait(driver, options.timeoutSeconds, 1000).until(ExpectedConditions.elementToBeClickable(
                            (locator)));
                    break;
                case PRESENT:
                    element = new WebDriverWait(driver, options.timeoutSeconds, 1000).until(ExpectedConditions
                            .presenceOfElementLocated((locator)));
                    break;
            }

        } catch (Exception e) {
            exception = e;
        }

        // If element cannot be found the check if test should fail
        if (element == null) {
            try {
                if (options.failOnNotFound) {
                    throw new Exception(exception);
                } else {
                    element = null;
                }
            } catch (Exception ex) {
                ex.initCause(ex);
            }
        } else {
            scrollToElement(element, options.scrollTo, options.scrollToOffset);
        }

        return element;
    }

    public WebElement waitFor(By locator) {
        return waitFor(locator, WFBuilder.options().build());
    }

    public void clickInsert(By locator, String message) {
        clickInsert(locator, message, WFBuilder.options().scrollTo(true).build());
    }

    public void clickInsert(By locator, String message, WFBuilder options) {
        WebElement element = waitFor(locator, options);
        element.click();
        clearText(element);
        SendKeys(message, element);
    }

    private void clearText(WebElement element) {
        if (RuntimeProperties.browser == Browser.Firefox) {
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            element.sendKeys(Keys.BACK_SPACE);

        } else {
            element.clear();
        }
    }

    private void SendKeys(String message, WebElement element) {
        slowKeys(element, message, 0.01);
    }

    private void slowKeys(WebElement element, String message, double seconds) {
        sleep(0.5, "Wait for field to be active before entering keys");
        char[] charArray = message.toCharArray();
        for (char c : charArray) {
            sleep(seconds, "Time between entering chars");
            element.sendKeys(String.valueOf(c));
        }
    }

    public void sleep(double seconds, String message) {
        try {
            Thread.sleep((int) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<WebElement> getListOfElements(By locator) {
        return getListOfElements(locator, WFBuilder.options().build());
    }

    public List<WebElement> getListOfElements(By locator, WFBuilder options) {
        List<WebElement> elementList = null;
        Exception exception = null;
        try {
            elementList = new WebDriverWait(driver, options.timeoutSeconds).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

        } catch (Exception e) {
            exception = e;
        }

        if (elementList != null) {
            return elementList;
        } else {
            try {
                if (options.failOnNotFound) {
                    throw new Exception(exception);
                }

            } catch (Exception e) {
                e.initCause(e);
            }
        }

        return null;
    }

    private void scrollToElement(WebElement element, boolean scrollTo, int scrollToOffset) {
        if (scrollTo) {
            javascript().executeScript("arguments[0].scrollIntoView(true);", element);
            javascript().executeScript("window.scrollBy(0, " + scrollToOffset + ")", "");
        }
    }

    private JavascriptExecutor javascript() {
        return (JavascriptExecutor) driver;
    }
}
