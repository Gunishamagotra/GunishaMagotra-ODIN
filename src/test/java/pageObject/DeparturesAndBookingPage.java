package pageObject;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DateUtil;

import java.time.Duration;
import java.util.List;

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
            Thread.sleep(3000);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void selectDateFromCalender() throws InterruptedException {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='md2-datepicker-button']"))).click();
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Next month']"))).click();
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Next month']"))).click();
            Thread.sleep(1000);

            WebElement dateWidgetFrom = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("md2-datepicker-1"))).get(0);

            //This are the columns of the from date picker table
            List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
            DateUtil dateUtil = new DateUtil();
            dateUtil.clickGivenDay(columns, "3");

            Thread.sleep(5000);

         //   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='page-count ng-star-inserted']"))).sendKeys(Keys.TAB);

    }

    public void addBooking(){
        // locate the table element
        WebElement table = getDriver().findElement(By.xpath("//ngx-datatable[@class='ngx-datatable material fixed-header virtualized']"));
        // locate all rows of the table
        List<WebElement> rows = table.findElements(By.xpath("//datatable-body-row"));
        // specify the row and column index
        int rowIndex = 1;
        int colIndex = 12;
        // locate the cell
        WebElement cell = rows.get(rowIndex - 1).findElements(By.xpath("//datatable-body-cell")).get(colIndex - 1);
        cell.click();
        // retrieve the cell value
       // String cellValue = cell.getText();
       // System.out.println("Cell value: " + cellValue);
    }

    public void verifyBooking() throws InterruptedException {
        // locate the table element
        WebElement table = getDriver().findElement(By.xpath("//ngx-datatable[@class='ngx-datatable material fixed-header virtualized']"));
        // locate all rows of the table
        List<WebElement> rows = table.findElements(By.xpath("//datatable-body-row"));
        // specify the row and column index
        int rowIndex = 1;
        int colIndex = 2;
        // locate the cell
        WebElement cell = rows.get(rowIndex - 1).findElements(By.xpath("//datatable-body-cell")).get(colIndex - 1);
        cell.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),' Bookings ')]"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='mat-input-39']"))).sendKeys("BE6301");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='mat-input-39']"))).sendKeys(Keys.ENTER);

        // retrieve the cell value
        String cellValue = cell.getText();
        System.out.println("Cell value: " + cellValue);
        WebElement table1 = getDriver().findElement(By.xpath("//ngx-datatable[@class='ngx-datatable material fixed-header virtualized']"));
//        // locate all rows of the table
        List<WebElement> rows1 = table.findElements(By.xpath("//datatable-body-row"));
//        // specify the row and column index
       int rowIndex1 = 1;
       int colIndex1 = 3;
//        // locate the cell
        WebElement cell1 = rows.get(rowIndex1 - 1).findElements(By.xpath("//datatable-body-cell")).get(colIndex1 - 1);
        String cellValue1 = cell1.getText();
        System.out.println("Cell value: " + cellValue1);
        Assert.assertEquals(cellValue1,"BE6301");
    }

    public void selectNewDate() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='md2-datepicker-button']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Next month']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Next month']"))).click();
        Thread.sleep(1000);

        WebElement dateWidgetFrom = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("md2-datepicker-2"))).get(0);

        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
        DateUtil dateUtil = new DateUtil();
        dateUtil.clickGivenDay(columns, "3");
        Thread.sleep(5000);
    }
}
