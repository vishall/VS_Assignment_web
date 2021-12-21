package utils;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.Map;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"utils", "stepdefinations"},
        tags = "@HomePage",
        plugin = {"pretty", "html:target/index.html", "json:target/reports/cucumber.json"},
        monochrome = true
        )
public class TestRunner {
    public static Map<String, String> config;
}

