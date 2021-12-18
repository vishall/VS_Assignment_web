package utils.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileHelper {
    public static final String FILE_SEPARATOR = File.separator;
    public static final String WORKING_DIRECTORY_PATH = System.getProperty("user.dir");

    public static FileInputStream readFile(String file) throws FileNotFoundException {
        return new FileInputStream(new File(file));
    }

    public static Map<String, String> readProperties() throws IOException {
        Properties prop = new Properties();
        prop.load(readFile("src/test/resources/config.properties"));

        Map<String, String> properties = new HashMap<>();

        Enumeration<?> KeyValues = prop.keys();
        while (KeyValues.hasMoreElements()) {
            String key = (String) KeyValues.nextElement();
            String value = prop.getProperty(key);
            properties.put(key, System.getProperty(key, value));
        }
        System.out.println(properties);
        return properties;

    }

}
