package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class State {

    public static long defaultTimeout = 15;
    // System level variables
    public WebDriver driver;
    public Scenario scenario;
}
