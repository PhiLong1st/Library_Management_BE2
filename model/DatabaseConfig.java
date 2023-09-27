package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfig {
    private String url;
    private String username;
    private String password;

    public void DatabaseConfiguration() {
        // System.out.println(System.getProperty("user.dir"));
        Properties properties = new Properties();
        try (FileInputStream configFile = new FileInputStream("config.properties")) {
            properties.load(configFile);
            url = properties.getProperty("database.url");
            username = properties.getProperty("database.username");
            password = properties.getProperty("database.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        DatabaseConfiguration();
        return url;
    }

    public String getUsername() {
        DatabaseConfiguration();
        return username;
    }

    public String getPassword() {
        DatabaseConfiguration();
        return password;
    }
}
