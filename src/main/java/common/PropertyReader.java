package common;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    Properties properties;
    String filePath; // = System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\TST04.properties";

    public PropertyReader(String filePath) {
        this.properties = new Properties();
        this.filePath = filePath;
        ;
    }

    public String readProperty(String propertyName) {
        String value = null;
        try {
            FileInputStream input = new FileInputStream(filePath);
            properties.load(input);
            value = properties.getProperty(propertyName);

        } catch (Exception e) {

        }
        return value;
    }
}
