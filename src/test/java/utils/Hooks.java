package utils;

import utils.SetUp.drivers.DriverSetUp;
import utils.helpers.FileHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;


public class Hooks {
    public BaseUtils base;

    public Hooks(BaseUtils baseUtil) {
        base = baseUtil;
    }

    @Before
    public void setup(Scenario scenario) throws IOException {
        TestRunner.config = FileHelper.readProperties();
        base.scenario = scenario;
        base.driver = new DriverSetUp().get(base);

    }

    @After
    public void tearDown() throws Exception {

        base.driver.quit();
    }
}
