package utils;

import enums.*;

public class RuntimeProperties {
    public static Environment environment = Environment.valueOf(TestRunner.config.get("environment"));
    public static Browser browser = Browser.valueOf(TestRunner.config.get("browser"));
}
