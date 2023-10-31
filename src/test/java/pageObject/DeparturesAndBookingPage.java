package pageObject;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DateUtil;

import java.time.Duration;
import java.util.List;

import static pageObject.BookingInfoPage.BookingID;

public class DeparturesAndBookingPage extends Base_PO{

    private @FindBy(xpath = "//a[contains(text(), 'Departures & Bookings')]")
    WebElement DepartureAndBooking;

    private @FindBy(xpath = "//button[@class='md2-datepicker-button']")
    WebElement calender;

    private @FindBy(xpath = "//div[@aria-label='Next month']")
    WebElement calenderNextMonth;


    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

    public void setDepartureAndBooking(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(DepartureAndBooking)).click();
            tinyWait();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void selectDateFromCalender() throws InterruptedException {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='md2-datepicker-button']"))).click();
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Next month']"))).click();
            tinyWait();
            WebElement dateWidgetFrom = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("md2-datepicker-1"))).get(0);

            //This are the columns of the from date picker table
            List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
            DateUtil dateUtil = new DateUtil();
            dateUtil.clickGivenDay(columns, "4");
            tinyWait();
    }

    public void addBooking(int rowIndex, int colIndex){
        // locate the table element
        WebElement table = getDriver().findElement(By.xpath("//ngx-datatable[@class='ngx-datatable material fixed-header virtualized']"));
        // locate all rows of the table
        List<WebElement> rows = table.findElements(By.xpath("//datatable-body-row"));
        // specify the row and column index
        // locate the cell
        WebElement cell = rows.get(rowIndex - 1).findElements(By.xpath("//datatable-body-cell")).get(colIndex - 1);
        cell.click();

    }

    public void selectBookingButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),' Bookings ')]"))).click();

    }

    public void verifyBooking(int row, int col) throws InterruptedException {
        addBooking(row,col);
        selectBookingButton();
        tinyWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mat-input-39']"))).sendKeys(BookingID);
        tinyWait();
        String ActualValue = bookingnumber();
        Assert.assertEquals(ActualValue,BookingID);
        quitDriver();

    }

    public String bookingnumber(){
        WebElement table1 = getDriver().findElement(By.xpath("//ngx-datatable[@class='ngx-datatable material fixed-header virtualized']"));
//        // locate all rows of the table
        List<WebElement> rows1 = table1.findElements(By.xpath("//datatable-body-row"));
//        // specify the row and column index
        int rowIndex1 = 1;
        int colIndex1 = 3;
//        // locate the cell
        WebElement cell1 = rows1.get(rowIndex1 - 1).findElements(By.xpath("//datatable-body-cell")).get(colIndex1 - 1);
        String cellValue1 = cell1.getText();
        return cellValue1;
    }

    public void selectNewDate() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='md2-datepicker-button']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Next month']"))).click();
        tinyWait();

        WebElement dateWidgetFrom = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("md2-datepicker-2"))).get(0);

        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
        DateUtil dateUtil = new DateUtil();
        dateUtil.clickGivenDay(columns, "4");
        longWait();
    }
}
