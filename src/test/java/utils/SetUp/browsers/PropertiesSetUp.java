package utils.SetUp.browsers;

import utils.helpers.FileHelper;

public class PropertiesSetUp {

    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";

    private static final String DRIVER_FOLDER = FileHelper.WORKING_DIRECTORY_PATH + FileHelper.FILE_SEPARATOR + "Executables" + FileHelper.FILE_SEPARATOR;

    private static final String CHROME_DRIVER_PATH = DRIVER_FOLDER + "chrome" + FileHelper.FILE_SEPARATOR;
    private static final String FIREFOX_DRIVER_PATH = DRIVER_FOLDER + "firefox" + FileHelper.FILE_SEPARATOR;

    private static final String MAC_CHROME_DRIVER = CHROME_DRIVER_PATH + "chromedriverMACOS";
    private static final String MAC_FIREFOX_DRIVER = FIREFOX_DRIVER_PATH + "geckodriverMACOS";


    public static void setChrome() {

        System.setProperty(CHROME_DRIVER_PROPERTY, MAC_CHROME_DRIVER);

    }

    public static void setFirefox() {

        System.setProperty(FIREFOX_DRIVER_PROPERTY, MAC_FIREFOX_DRIVER);
    }

}
