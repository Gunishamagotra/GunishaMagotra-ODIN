package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObject.*;


public class stepDefinition extends Base_PO {

    private WebDriver driver= getDriver();
    private Login_PO login_po;

    public stepDefinition(Login_PO login_po){
        this.login_po= login_po;

    }

    HomePage_PO homePage_po = new HomePage_PO();
    BookingInfoPage bookingInfoPage = new BookingInfoPage();
    DeparturesAndBookingPage departuresAndBookingPage = new DeparturesAndBookingPage();



    //    @Given("User is able to Login successfully")
//    public void user_is_able_to_login_successfully() {
//        Login_PO loginPo = new Login_PO();
//        loginPo.navigateToLoginPage();
//        loginPo.setClickLoginButton();
//    }
    @When("User creates a booking for Bunratty Castle tour for 3rd Dec {int}")
    public void user_creates_a_booking_for_bunratty_castle_tour_for_3rd_dec(Integer int1) {
        System.out.println("Test");
    }
    @Then("Booking should be successfully created")
    public void booking_should_be_successfully_created() {
        System.out.println("test");
    }

    @Given("User is able to Login successfully")
    public void userIsAbleToLoginSuccessfully() {
    login_po.navigateToLoginPage();
    login_po.setClickLoginButton();
    login_po.ClickMembers();
    login_po.enterUserName();
    login_po.clickNextButton();
    login_po.enterPassword();
    login_po.clickNextButton();
    login_po.clickNextButton();
    login_po.verifyHomePage();

    }
    @When("User creates a new booking")
    public void user_creates_a_new_booking() throws InterruptedException {
        homePage_po.clickTourManagement();
        departuresAndBookingPage.setDepartureAndBooking();
        departuresAndBookingPage.selectDateFromCalender();
        departuresAndBookingPage.addBooking();
        bookingInfoPage.fillUpAndSaveUserInfo();
    }
    @Then("booking should be created successfully")
    public void booking_should_be_created_successfully() throws InterruptedException {
        Thread.sleep(5000);
        departuresAndBookingPage.setDepartureAndBooking();
        departuresAndBookingPage.selectNewDate();
      //  departuresAndBookingPage.addBooking();
        departuresAndBookingPage.verifyBooking();





    }


}
