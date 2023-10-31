package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DateUtil;

import java.time.Duration;
import java.util.List;


public class HomePage_PO extends Base_PO {

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

    private @FindBy(xpath = "//div[contains(text(), 'Tour Management ')]")
    WebElement TourManagement;

    public void clickTourManagement() {
        try {
            tinyWait();
            wait.until(ExpectedConditions.elementToBeClickable(TourManagement)).click();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}


