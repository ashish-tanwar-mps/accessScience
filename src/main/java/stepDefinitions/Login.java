package stepDefinitions;

import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import testRailManager.TestRailManager;
import utility.WebDriverController;
import utility.CommonFunctions;
import utility.PropertyFile;

import PageObjects.LoginPgObj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login {

	WebDriverController maindriver = new WebDriverController();
	//	WebDriver driver = maindriver.rdriver();
	WebDriver driver = maindriver.initialize_webdriver();
	LoginPgObj lpo = new LoginPgObj(driver);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	TestRailManager testrail = new TestRailManager();
	static Logger log = Logger.getLogger(Login.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	PropertyFile propp = new PropertyFile();
	Properties p = propp.propertyf();
	CommonFunctions cmf= new CommonFunctions();

	//	Step Definitions

	@Given("user lands on MHE Access Science homepage")
	public void user_lands_on_access_science_homepage() {
		try {
			System.out.println("Driver Launched : User Lands on Homepage");
			log.info("Driver Launched : User Lands on Homepage");

			wait.until(ExpectedConditions.visibilityOf(lpo.headerLogo));
			
			if(lpo.headerLogo.isDisplayed()) {
				System.out.println("User successfully land on homepage");
				log.info("User successfully land on homepage");
				testrail.addResultsToTestrail("Pass", "448450", "User successfully land on homepage");
			}else {
				System.out.println("Homepage landing unsuccessfull");
				log.info("Homepage landing unsuccessfull");
				testrail.addResultsToTestrail("Fail", "448450", "Homepage landing unsuccessfull");
			}
		}catch(Exception e) {
			log.info("------------------FAILED : Due to exception---------------------" + e);
			testrail.addResultsToTestrail("Fail", "448450", "Failed : Due to exception : "+e);
		}
	}

	@Then("user click on my account button")
	public void user_click_on_my_account_button() {

		try {
			wait.until(ExpectedConditions.visibilityOf(lpo.myAccountBtn));
			wait.until(ExpectedConditions.elementToBeClickable(lpo.myAccountBtn));
			lpo.click_my_account_button();

			wait.until(ExpectedConditions.visibilityOf(lpo.manageAccesstext));
			wait.until(ExpectedConditions.elementToBeClickable(lpo.manageAccesstext));
			if(lpo.manageAccesstext.isDisplayed()) {
				System.out.println("My account button is working");
				log.info("My account button is working");
				testrail.addResultsToTestrail("Pass", "448451", "My account button is working");
			}else {
				System.out.println("My account button is not working");
				log.info("My account button is not working");
				testrail.addResultsToTestrail("Fail", "448451", "My account button is not working");
			}
		}catch(Exception e) {
			log.info("------------------FAILED : Due to exception---------------------" + e);
			testrail.addResultsToTestrail("Fail", "448451", "Failed : Due to exception : "+e);
		}
	}

	@Then("user enters Username {string}")
	public void user_enters_username(String username) {
		try {
			wait.until(ExpectedConditions.visibilityOf(lpo.forgotPasswordLink));
			wait.until(ExpectedConditions.elementToBeClickable(lpo.forgotPasswordLink));
			lpo.Username(username);
			log.info("Entered username.........");
		}catch(Exception e) {
			log.info("------------------FAILED : Due to exception---------------------" + e);
			//	     	testrail.addResultsToTestrail("pass", "446677", "Failed : Due to exception"+e);
		}
	}

	@Then("enter Password {string}")
	public void enter_password(String password) {
		try {
			lpo.Password(password);
			log.info("Entered password.........");
		}catch(Exception e) {
			log.info("------------------FAILED : Due to exception---------------------" + e);
			//	     	testrail.addResultsToTestrail("pass", "446677", "Failed : Due to exception"+e);
		}
	}

	@And("click on login button")
	public void click_on_login_button() {
		try {
			wait.until(ExpectedConditions.visibilityOf(lpo.loginbtn));
			wait.until(ExpectedConditions.elementToBeClickable(lpo.loginbtn));
			lpo.Submitbtn();
		}catch(Exception e) {
			log.info("------------------FAILED : Due to exception---------------------" + e);
			//	     	testrail.addResultsToTestrail("pass", "446677", "Failed : Due to exception"+e);
		}

	}

	@Then("user click on logout button")
	public void user_click_on_logout_button() throws InterruptedException {

		try {
			wait.until(ExpectedConditions.visibilityOf(lpo.logOutBtn));
			wait.until(ExpectedConditions.elementToBeClickable(lpo.logOutBtn));
			lpo.click_logout_button();

			user_click_on_profile_logout_button();

			wait.until(ExpectedConditions.visibilityOf(lpo.myAccountBtn));
			wait.until(ExpectedConditions.elementToBeClickable(lpo.myAccountBtn));

			if(lpo.myAccountBtn.isDisplayed()) {
				System.out.println("Logout successful");
				log.info("Logout successful");
				testrail.addResultsToTestrail("Pass", "485251", "Logout Successful");
			}else {
				System.out.println("Logout not successful");
				log.info("Logout not successful");
				testrail.addResultsToTestrail("Fail", "485251", "Logout not Successful");
			}
		}catch(Exception e) {
			log.info("------------------FAILED : Due to exception---------------------" + e);
			testrail.addResultsToTestrail("Fail", "448451", "Failed : Due to exception : "+e);
		}
	}

	@Then("user click on profile logout button")
	public void user_click_on_profile_logout_button() throws InterruptedException {

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(lpo.profileLogOutBtn));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.profileLogOutBtn));
		lpo.click_profile_logout_button();
		log.info("User successfully logout the session");
	}

	@Then("user click on my account drop down button")
	public void user_click_on_my_account_drop_down_button() {

		wait.until(ExpectedConditions.visibilityOf(lpo.headerLogo));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.headerLogo));
		lpo.myAccountDropDwnBtn.click();
		log.info("My account drop down button clicked");
	}

	@Then("verification of user info for successfull login verification by username {string}")
	public void verification_of_user_info_for_successfull_login_verification_by_username(String text){

		try {
			user_click_on_my_account_drop_down_button();

			wait.until(ExpectedConditions.visibilityOf(lpo.userInfo));
			String userInfoText = lpo.get_user_info_text();
			log.info("Actual User Info is : "+userInfoText);
			log.info("Expected User Info is : "+text);

			if(userInfoText.equals(text)) {
				System.out.println("Login successful with valid credentials");
				log.info("Login successful with valid credentials");
				testrail.addResultsToTestrail("Pass", "448452", "Login successful with valid credentials");
			}else {
				System.out.println("Login not successful with valid credentials");
				log.info("Login not successful with valid credentials");
				testrail.addResultsToTestrail("Fail", "448452", "Login not successful with valid credentials");
			}
		}catch(Exception e) {
			log.info("------------------FAILED : Due to exception---------------------" + e);
			testrail.addResultsToTestrail("Fail", "448452", "Failed : Due to exception : "+e);
		}
	}

	@Then("validate error message display with invalid credentials {string}")
	public void validate_error_message_display_with_invalid_credentials(String errormessage) {

		wait.until(ExpectedConditions.visibilityOf(lpo.errorToastMsg));
		String actualErrorMsg = lpo.get_error_toast_message_text();
		log.info("Expected Error message is :"+ errormessage);
		log.info("Actual error message is : "+ actualErrorMsg);

		if(actualErrorMsg.equals(errormessage)) {
			System.out.println("Error message matched : Invalid login credentials");
			log.info("Error message matched : Invalid login credentials");
			// testrail.addResultsToTestrail("pass", "446672", "Error message matched : Invalid login credentials");
		}else {
			System.out.println("Error message not matched");
			log.info("Error message not matched");
			// testrail.addResultsToTestrail("fail", "446672", "Error message not matched");
		}

	}

	@Then("click forgot password link")
	public void click_forgot_password_link() {

		wait.until(ExpectedConditions.visibilityOf(lpo.forgotPasswordLink));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.forgotPasswordLink));
		lpo.click_forgot_password_link();

	}

	@Then("enter email address to recovery of the password {string}")
	public void enter_email_address_to_recovery_of_the_password(String username) {

		wait.until(ExpectedConditions.visibilityOf(lpo.frgtpasswrdsbmtbtn));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.frgtpasswrdsbmtbtn));
		lpo.Forgotpasswordemail(username);
	}

	@Then("click on submit button on forgot password page")
	public void click_on_submit_button_on_forgot_password_page() {

		wait.until(ExpectedConditions.visibilityOf(lpo.frgtpasswrdsbmtbtn));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.frgtpasswrdsbmtbtn));
		lpo.click_forgot_password_submit_button();

	}

	@Then("enter reset password code {string}")
	public void enter_reset_password_code(String code) {

		wait.until(ExpectedConditions.visibilityOf(lpo.resetpasswordcode));
		lpo.enter_reset_password_code(code);
	}

	@Then("enter new password {string}")
	public void enter_new_password (String resetpassword) {

		wait.until(ExpectedConditions.visibilityOf(lpo.newpassword));
		lpo.enter_new_password(resetpassword);
	}

	@Then("enter confirm password {string}")
	public void enter_confirm_password (String confirmpassword) {

		wait.until(ExpectedConditions.visibilityOf(lpo.confirmpswd));
		lpo.enter_confirm_password(confirmpassword);
	}

	@Then("click on return to the website link")
	public void click_on_return_to_the_website_link() {

		wait.until(ExpectedConditions.visibilityOf(lpo.returnToTheWebsiteLink));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.returnToTheWebsiteLink));
		lpo.click_return_to_the_website_link();
	}

	@Then("user click on register link")
	public void user_click_on_register_link() {

		wait.until(ExpectedConditions.visibilityOf(lpo.registerbtn));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.registerbtn));
		lpo.click_on_register_link();

	}

	@Then("user enters full name {string}")
	public void user_enters_full_name(String fullname) {

		wait.until(ExpectedConditions.visibilityOf(lpo.fullName));
		lpo.enter_fullname(fullname);

	}

	@Then("user enters email address {string}")
	public void user_enters_email_address(String email) {

		wait.until(ExpectedConditions.visibilityOf(lpo.emailAddress));
		lpo.enter_email_address(email);
	}

	@Then("user select date of birth")
	public void user_select_date_of_birth() {

		wait.until(ExpectedConditions.visibilityOf(lpo.datepicker));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.datepicker));
		lpo.click_date_picker();

		lpo.select_month();
		lpo.select_year();
		lpo.select_date();
	}

	@Then("user select country")
	public void user_select_country() {

		wait.until(ExpectedConditions.visibilityOf(lpo.country));
		lpo.select_country();
	}

	@Then("user enter password for registration{string}")
	public void user_enter_password_for_registration(String password) {

		wait.until(ExpectedConditions.visibilityOf(lpo.regpassword));
		lpo.enter_registration_password(password);
	}

	@Then("user enter confirm password for registration{string}")
	public void user_enter_confirm_password_for_registration(String confirmpassword) {

		wait.until(ExpectedConditions.visibilityOf(lpo.confpassword));
		lpo.enter_confirm_password_for_registration(confirmpassword);
	}

	@Then("user clicks on registeration button")
	public void user_clicks_on_registeration_button() {

		wait.until(ExpectedConditions.visibilityOf(lpo.registerationbtn));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.registerationbtn));
		lpo.click_registration_button();
	}

	@Then("verify the text on verify your email page")
	public void verify_the_text_on_verify_your_email_page() {

		wait.until(ExpectedConditions.visibilityOf(lpo.text));

		if(lpo.text.isDisplayed()) {
			System.out.println("Registration Successfull");
			log.info("Registration successfull");
			// testrail.addResultsToTestrail("Pass", "446672", "Registration successfull");
		}else {
			System.out.println("Registration not Successfull");
			log.info("Registration not successfull");
			// testrail.addResultsToTestrail("Fail", "446672", "Registration not successfull");
		}
	}

	@Then("user click on login via library card link")
	public void user_click_on_login_via_library_card_link() {

		wait.until(ExpectedConditions.visibilityOf(lpo.libraryLoginLink));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.libraryLoginLink));
		lpo.click_login_via_library_card_link();
	}

	@Then("select you library {string}")
	public void select_you_library (String library) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(lpo.findLibrary));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.findLibrary));
		lpo.find_your_library(library);

	}

	@Then("enter library card number  {string}")
	public void enter_library_card_number (String cardnumber) {

		wait.until(ExpectedConditions.visibilityOf(lpo.librarycardnum));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.librarycardnum));
		lpo.enter_library_card_number(cardnumber);
	}

	@Then("user click on login button on login via library card page")
	public void user_click_on_login_button_on_login_via_library_card_page() {

		wait.until(ExpectedConditions.visibilityOf(lpo.libraryloginbtn));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.libraryloginbtn));
		lpo.click_library_login_button();
	}

	@Then("verify branding logo text {string}")
	public void verify_branding_logo_text(String brandingtext) {

		wait.until(ExpectedConditions.visibilityOf(lpo.brandingLogoText));
		String actualLoginText = lpo.get_branding_logo_text();
		log.info("Actual Login text is : "+actualLoginText);
		log.info("Expected Login text is : "+brandingtext);

		if(actualLoginText.equals(brandingtext)) {
			System.out.println("Branding logo text verified-Login via Library card is successfull");
			log.info("Branding logo text verified-Login via Library card is successfull");
			//			 testrail.addResultsToTestrail("pass", "446672", "Branding logo text verified-Login via Library card is successfull");
		}else {
			System.out.println("Branding logo text not verified-Login via Library card is not successfull");
			log.info("Branding logo text not verified-Login via Library card is not successfull");
			// testrail.addResultsToTestrail("fail", "446672", "Branding logo text not verified-Login via Library card is not successfull");
		}	
	}

	@Then("user click on redeem voucher link")
	public void user_click_on_redeem_voucher_link() {

		wait.until(ExpectedConditions.visibilityOf(lpo.redeemvoucher));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.redeemvoucher));
		lpo.click_redeem_voucher_link();
	}

	@And("verify the text message {string}")
	public void verify_the_text_message (String textmsg) {

		wait.until(ExpectedConditions.visibilityOf(lpo.vouchertxtmsg));
		String actualVoucherText= lpo.get_voucher_msg_text();
		log.info("Actual voucher text is : "+actualVoucherText);
		log.info("Expected voucher text is : "+ textmsg);

		if(actualVoucherText.equals(textmsg)) {
			System.out.println("Voucher text message verified");
			log.info("Voucher text message verified");
			// testrail.addResultsToTestrail("pass", "446672", "Voucher text message verified");
		}else {
			System.out.println("Voucher text message not verified");
			log.info("Voucher text message not verified");
			// testrail.addResultsToTestrail("fail", "446672", "Voucher text message not verified");
		}
	} 

	@Then("enter voucher code {string}")
	public void enter_voucher_code (String vouchercode) {

		wait.until(ExpectedConditions.visibilityOf(lpo.voucherCode));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.voucherCode));
		lpo.enter_voucher_code(vouchercode);
	}

	@Then("user click on redeem voucher button")
	public void user_click_on_redeem_voucher_button() {

		wait.until(ExpectedConditions.visibilityOf(lpo.redeemVoucherBtn));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.redeemVoucherBtn));
		lpo.click_redeem_voucher_button();
	}

	@Then("verify redeem voucher alert message {string}")
	public void verify_redeem_voucher_alert_message (String textalertmsg) {

		wait.until(ExpectedConditions.visibilityOf(lpo.redeemAlertMsg));
		String actualAlertMsg = lpo.get_redeem_alert_message_text();
		log.info("Actual redeem alert message is : "+actualAlertMsg);
		log.info("Expected redeem alert message is : "+textalertmsg);

		if(actualAlertMsg.equals(textalertmsg)) {
			System.out.println("Redeem voucher alert message verified");
			log.info("Redeem voucher alert message verified");
			// testrail.addResultsToTestrail("pass", "446672", "Redeem voucher alert message verified");
		}else {
			System.out.println("Redeem voucher alert message not verified");
			log.info("Redeem voucher alert message not verified");
			// testrail.addResultsToTestrail("pass", "446672", "Redeem voucher alert message not verified");
		}
	}

	@Then("click on login via your institution link")
	public void click_on_login_via_your_institution_link() {

		wait.until(ExpectedConditions.visibilityOf(lpo.institutelogin));
		wait.until(ExpectedConditions.elementToBeClickable(lpo.institutelogin));
		lpo.click_login_via_your_institution_link();
	}

	@Then("verify the text on SAMS SIGMA page {string}")
	public void verify_the_text_on_SAMS_SIGMA_page (String pagetext) {

		wait.until(ExpectedConditions.visibilityOf(lpo.sigmaText));
		String actualSigmaText = lpo.get_sams_sigma_heading_text();
		log.info("Actual sigma heading text is : "+actualSigmaText);
		log.info("Expected sigma heading text is : "+pagetext);

		if(actualSigmaText.equals(pagetext)) {
			System.out.println("Sams Sigma heading text verified");
			log.info("Sams Sigma heading text verified");
			// testrail.addResultsToTestrail("pass", "446672", "Sams Sigma heading text verified");
		}else {
			System.out.println("Sams Sigma heading text not verified");
			log.info("Sams Sigma heading text not verified");
			// testrail.addResultsToTestrail("fail", "446672", "Sams Sigma heading text not verified");
		}
	}

	@Then("select your organization {string}")
	public void select_your_organization (String organization) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(lpo.instituteName));
		lpo.enter_institute_name(organization);
	}

	@Then("close the browser")
	public void close_the_browser() {

		driver.quit();
		log.info("Browser closed successfully");
	}
}
