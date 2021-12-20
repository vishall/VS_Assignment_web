package utils.helpers;

import enums.Environment;
import utils.RuntimeProperties;

import java.io.IOException;

public class SiteUrl {

    public static String url(Environment environment) throws IOException {
        String url = "";

        if (RuntimeProperties.environment == Environment.TEST) {
            url = "https://coinmarketcap.com/";
        }
        //we can extend it further for multiple environments
        return url;
    }
}
