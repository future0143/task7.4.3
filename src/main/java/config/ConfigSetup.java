package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;

public interface ConfigSetup {

    @BeforeAll
    static void openBrowser() {
        WebDriverManager.chromedriver().setup();
    }
}