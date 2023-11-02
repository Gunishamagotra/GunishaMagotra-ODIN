package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

public static WebDriver getDriver(){
    if (driver.get() == null){
        driver.set(createDriver());
    }

    return driver.get();
}

private static WebDriver createDriver(){
  WebDriver  driver= null;

    String browserType= "chrome";

    switch (getBrowserType()){
        case "chrome": {

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/java/driver/drivers/chromedriver.exe");
            ChromeOptions chromeOptions= new ChromeOptions();
           chromeOptions.addArguments("--remote-allow-origins=*");

            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver= new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            break;
        }
        case "edge": {

            System.setProperty("webdriver.edge.driver", "/Applications/Microsoft Edge.app/Contents/MacOS/Microsoft Edge");
            EdgeOptions edgeOptions= new EdgeOptions();
            edgeOptions.addArguments("");
            edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver= new EdgeDriver(edgeOptions);
            //driver.manage().window().maximize();
            break;
        }
    }
    driver.manage().window().maximize();
    return driver;

}

public static String getBrowserType() {
    String browserType = null;
    String browserTypeRemoteValue = System.getProperty("browserType");
    try {
        if (browserTypeRemoteValue == null || browserTypeRemoteValue.isEmpty()) {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/config.properties");
            properties.load(file);
            browserType = properties.getProperty("browser").toLowerCase().trim();
        } else {
            browserType = browserTypeRemoteValue;
        }}
        catch(IOException io){

            System.out.println(io.getMessage());
        }
        return browserType;
    }

public static void tearDownBrowser()
    {
        getDriver().quit();

    }


}
