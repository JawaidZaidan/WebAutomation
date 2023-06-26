package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebConnector {

    public static WebDriver driver = null;

    public WebDriver openBrowser() throws IOException {
        String os = System.getProperty("os.name");
        System.out.println("\n\nCurrent OS is : " + os);
        driver = null;

        if (driver == null) {
            if (os.equalsIgnoreCase("mac os x")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else {

                Runtime.getRuntime().exec("sudo apt-get install xvfb");
                WebDriverManager.chromedriver().setup();
                ChromeDriverService service = ChromeDriverService.createDefaultService();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--headless");
                options.setBinary("/usr/bin/google-chrome");
                options.addArguments("disable-dev-shm-usage"); // recommended for running in Docker
                options.addArguments("no-sandbox"); // recommended for running in Docker
                options.addArguments("start-maximized"); // recommended for running in Docker
                options.addArguments("disable-gpu"); // recommended for running in Docker
                options.setExperimentalOption("useAutomationExtension", false);
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-component-update", "disable-default-apps", "disable-popup-blocking"));
                Runtime.getRuntime().exec("xvfb-run -a -s \"-screen 0 1920x1080x24\" google-chrome");
                driver = new ChromeDriver(service, options);
            }

                // Maximize Window
                driver.manage().window().maximize();

                // Implicit wait
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        }
        return driver;
    }


    public static WebDriver getWebDriver () {
        return driver;
    }

}

