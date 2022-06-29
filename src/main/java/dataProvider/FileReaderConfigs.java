package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileReaderConfigs {

    private static Properties properties;
    private final String propertyFilePath = "/Users/nata/IdeaProjects/Diploma2022/src/main/java/configs/Configuration.properties";

    public FileReaderConfigs() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getValidUserName() {
        String username = properties.getProperty("username");
        if (username != null) return username;
        else throw new RuntimeException("userName not specified in the Configuration.properties file.");
    }

    public String getValidPassword() {
        String password = properties.getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }

    public String getInvalidUserName() {
        String username = properties.getProperty("invalidUsername");
        if (username != null) return username;
        else throw new RuntimeException("userName not specified in the Configuration.properties file.");
    }

    public String getInvalidPassword() {
        String password = properties.getProperty("invalidPassword");
        if (password != null) return password;
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }


}
