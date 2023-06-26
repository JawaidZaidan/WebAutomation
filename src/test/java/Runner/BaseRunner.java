package Runner;

import org.testng.annotations.*;
import utils.*;

import java.io.IOException;

public class BaseRunner extends WebConnector {

    @BeforeSuite
    public void initializeDriver() throws IOException {
        openBrowser();
    }

    @AfterSuite
    public static void tearDown() {
        try {
            driver.quit();
        }
        catch (Exception c)
        {
            System.out.println("Driver already closed...");
        }

    }
}
