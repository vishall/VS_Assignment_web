package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class State {

    // System level variables
    public WebDriver driver;
    public static long defaultTimeout = 15;
    public Scenario scenario;
}
