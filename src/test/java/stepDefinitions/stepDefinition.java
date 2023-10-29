package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObject.Base_PO;
import pageObject.Login_PO;


public class stepDefinition extends Base_PO {

    private WebDriver driver= getDriver();
    private Login_PO login_po;

    public stepDefinition(Login_PO login_po){
        this.login_po= login_po;

    }



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

        Login_PO loginPo = new Login_PO();
       loginPo.navigateToLoginPage();
     loginPo.setClickLoginButton();    }
}
