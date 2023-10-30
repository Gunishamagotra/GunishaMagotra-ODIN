package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.sql.Timestamp;

import static driver.DriverFactory.getDriver;
import static driver.DriverFactory.tearDownBrowser;

public class Hooks {
    public WebDriver driver;
    @Before()
    public void setup()
    {
        getDriver();

    }
    @After
    public void captureExceptionImage(Scenario scenario){
        if (scenario.isFailed()){
            Timestamp timestamp= new Timestamp(System.currentTimeMillis());
            String time= String.valueOf(timestamp.getTime());

            byte[] screenshot= ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",time);

        }
    }
    @After
    public void teardown()
    {
        tearDownBrowser();
    }

}
