package Pages;

import PageObjects.TestingPageObjects;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Wait;
import utils.WebConnector;


public class TestingPage extends WebConnector {

    TestingPageObjects testingPageObjects = new TestingPageObjects(driver);


    public void openURL() {
        driver.get("https://www.daraz.pk/");
    }

    public String getPageTitle() {
        System.out.println(driver.getTitle());
        return driver.getTitle();
    }

    public void clickLogin() {
        Wait.WaitForWebElement().until(ExpectedConditions.visibilityOf(testingPageObjects.login_link)).click();
    }
}
