package Step_Definitions;

import Pages.TestingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.Assert;
import utils.WebConnector;
import java.io.IOException;


public class TestingSteps extends WebConnector {

    TestingPage testingPage = new TestingPage();


    @Given("I open the daraz URL")
    public void openURL() throws IOException {
//        openBrowser();
        testingPage.openURL();
    }

    @When("I assert the title of the page")
    public void VerifyPageTitle() {
        Assert.assertEquals(testingPage.getPageTitle(), "Online Shopping in Pakistan: Fashion, Electronics & Groceries - Daraz.pk");
    }

    @And("I click on login")
    public void clickLogin() {
        testingPage.clickLogin();
    }
}
