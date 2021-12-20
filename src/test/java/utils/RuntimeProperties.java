package utils;

import enums.Browser;
import enums.Environment;

public class RuntimeProperties {
    public static Environment environment = Environment.valueOf(TestRunner.config.get("environment"));
    public static Browser browser = Browser.valueOf(TestRunner.config.get("browser"));
    public static String username = TestRunner.config.get("username");
    public static String password = TestRunner.config.get("password");
}
