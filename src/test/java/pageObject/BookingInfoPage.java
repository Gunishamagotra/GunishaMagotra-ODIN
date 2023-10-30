package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingInfoPage extends Base_PO{

    private @FindBy(xpath = "//input[@data-placeholder='First Name']")
    WebElement firstName;

    private @FindBy(xpath = "//input[@data-placeholder='Last Name']")
    WebElement lastName;

    private @FindBy(xpath = "//input[@data-placeholder='Phone']")
    WebElement phone;

    private @FindBy(xpath = "//input[@data-placeholder='Email']")
    WebElement email;

    private @FindBy(xpath = "//input[@id='mat-input-7']")
    WebElement numberOfPassengers;

    private @FindBy(xpath = "//button[@class='mat-focus-indicator dialog-actions__button dialog-actions__button--save mat-flat-button mat-button-base mat-accent']")
    WebElement saveInfo;

    private @FindBy(xpath = "//ng-select[@class='ng-select-searchable ng-select-clearable ng-select ng-select-single ng-star-inserted ng-touched ng-dirty ng-invalid']")
    WebElement dropdown;

    private @FindBy(xpath = "//form/cmt-dynamic-control[1]/div/ng-select/div/div/div[2]")
    WebElement dropdown1;

    private @FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/cmt-create-booking-modal-form/mat-dialog-content/mat-card[6]/mat-card-content/form/cmt-dynamic-control[3]/div/ng-select/div/div/div[2]/input")
    WebElement selectInvoice;

    private @FindBy(xpath = "//div[contains(text(), 'Select origin')]")
    WebElement dropdownArrow;
    private @FindBy(xpath = "//ng-dropdown-panel[@aria-label='Options list']//div[contains(text(),' ATC Language Schools')]")
    WebElement selectOrigin;

    private @FindBy(xpath = "//*[@id='mat-dialog-0']/cmt-create-booking-modal-form/mat-dialog-actions/button[1]/span[1]/cmt-button-loading-indicator/div")
    WebElement saveBooking;

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

    public void fillUpAndSaveUserInfo(){
        try {
            sendKeys(firstName, "Guns"+generateRandomNumber(1,10));
            sendKeys(lastName, "gg"+generateRandomNumber(1,10));
            sendKeys(phone, "0873521611"+ generateRandomNumber(1,5));
            sendKeys(email, "test" + generateRandomNumber(1,5)+"@gmail.com");
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='mat-input-7']"))).clear();
            //  numberOfPassengers.clear();
            sendKeys(numberOfPassengers, "2");
            //  click(dropdown);
            click(dropdown1);
            click(selectOrigin);
            click(selectInvoice);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Already invoiced')]"))).click();
            Thread.sleep(5000);
            click(saveBooking);
            click(saveBooking);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mat-dialog-0']/cmt-create-booking-modal-form/mat-dialog-actions/button[1]/span[1]/cmt-button-loading-indicator/div"))).click();
        } catch(Exception e){
            e.printStackTrace();
        }
        // click(saveInfo);
    }
}
