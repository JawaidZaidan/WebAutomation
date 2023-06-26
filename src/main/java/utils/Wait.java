package utils;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static utils.WebConnector.driver;

public class Wait {

    private static WebDriverWait wait = null;


    public static WebDriverWait WaitForWebElement()
    {
        if(wait == null) {
            return new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        else {
            return wait;
        }
    }
}
