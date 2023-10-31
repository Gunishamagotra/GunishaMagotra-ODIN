package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_PO extends Base_PO {
    private @FindBy(id = "text")
    WebElement UsernameTextBox;

    private @FindBy(xpath = "//button[@class='mat-focus-indicator auth-content__button--login mat-flat-button mat-button-base mat-accent']")
    WebElement clickLoginButton;

    private @FindBy(xpath = ".//a[contains(@href,'ExternalLogin')]")
    WebElement clickMembers;

    private @FindBy(name = "loginfmt")
    WebElement emailID;

    private @FindBy(id = "idSIButton9")
    WebElement clickNextButton;

    private @FindBy(id = "i0118")
    WebElement password;

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));


    public Login_PO() {
        super();
    }

    public void navigateToLoginPage() {
        navigateToURL("https://dev-comet.azurewebsites.net/login");

    }

    public void setUsername(String text) {
        sendKeys(UsernameTextBox, text);
    }

    public void setClickLoginButton() {
        click(clickLoginButton);
    }

    public void ClickMembers() {
        wait.until(ExpectedConditions.elementToBeClickable(clickMembers));
        clickMembers.click();
    }

    public void enterUserName() {
        wait.until(ExpectedConditions.elementToBeClickable(emailID)).sendKeys("AM@tourtoise.onmicrosoft.com");
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(clickNextButton));
        clickNextButton.click();
    }

    public void enterPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys("5678HaonDo");
    }

    public void verifyHomePage(){
        Assert.assertEquals(getDriver().getTitle(),"Pax365");
    }


}
