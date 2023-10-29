package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO {
    private @FindBy(id = "text")
    WebElement UsernameTextBox;



    private @FindBy(xpath = "//button[@class='mat-focus-indicator auth-content__button--login mat-flat-button mat-button-base mat-accent']")
    WebElement clickLoginButton;

//    private @FindBy

//    private @FindBy(id= "login-button")
//    WebElement clickLoginButton;


    public Login_PO(){
        super();
    }
    public void navigateToLoginPage(){
        navigateToURL("https://dev-comet.azurewebsites.net/login");

    }

    public void setUsername(String text){
        sendKeys(UsernameTextBox, text);
    }

    public void setClickLoginButton(){
        click(clickLoginButton);
    }


}
