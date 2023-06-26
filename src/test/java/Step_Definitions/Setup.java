package Step_Definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.WebConnector;

import java.io.File;
import java.io.IOException;

import java.time.LocalDate;
import java.time.LocalTime;


public class Setup extends WebConnector {

    @Before
    public void BeforeLogging(Scenario scenario) {
        System.out.println("/******************************************************************************************************/");
        System.out.println("/******************************************************************************************************/");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("/******************************************************************************************************/");
        System.out.println("Scenario Id :  - " + scenario.getId());
        System.out.println("/******************************************************************************************************/");
        System.out.println("Scenario Tags :  - " + scenario.getSourceTagNames());
        System.out.println("/******************************************************************************************************/");

    }


    @After
    public void after(Scenario scenario) throws IOException {
        System.out.println("/------------------------------------------------------------------------------------------------------/");
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        if (scenario.isFailed()) {
            String rootDirectoryPath = System.getProperty("user.dir");
            String directoryName = rootDirectoryPath+"/Images/"+ LocalDate.now()+"/";
            File directory = new File(directoryName);
            if(!directory.exists())
            {
                directory.mkdir();
            }

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File targetFile=new File(directory+ "/" + LocalTime.now().toString().replaceAll(":","") +" - " +scenario.getName()+".jpg");
            FileUtils.copyFile(screenshot,targetFile);


        }

        System.out.println("/------------------------------------------------------------------------------------------------------/");
    }



}
