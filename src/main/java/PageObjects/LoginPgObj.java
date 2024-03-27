package PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import PageObjects.LoginPgObj;

public class LoginPgObj {

	WebDriver driver ;
	static Logger log = Logger.getLogger(LoginPgObj.class);

	
	
	public LoginPgObj(WebDriver driver )
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	Web Elements
	
	@FindBy(xpath="//a[@class='dropdown-toggle user__icon']")
	public WebElement myAccountBtn;
	
	@FindBy(xpath="//a[@class='dropdown-toggle navigation__item__toggle user__icon']")
	public WebElement myAccountDropDwnBtn;
	
	@FindBy(xpath ="//input[@id='username']")
	public WebElement Username;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement Password;

	@FindBy(xpath = "//button[@class='btn']")
	public WebElement loginbtn;
	
	@FindBy(xpath = "//a[@class='additional-link']")
	public WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Log out']")
	public WebElement logOutBtn;
	
	@FindBy(xpath="//div[@class='highwire-personalization-user-info__name']")
	public WebElement userInfo;
	
	@FindBy(xpath="//div[@class='header__brand']//img[@class='brand__logo']")
	public WebElement headerLogo;
	
	@FindBy(xpath="//div[@class='ng-binding']")
	public WebElement manageAccesstext;
	
	@FindBy(xpath="//a[@class='profile-logout']")
	public WebElement profileLogOutBtn;
	
	@FindBy(xpath="//div[@id='alert-error']")
	public WebElement errorToastMsg;
	
	@FindBy(xpath ="//input[@id='email']")
	public  WebElement forgotpasswordemail;
	
	@FindBy(xpath ="//span[normalize-space()='Submit']")
	public WebElement frgtpasswrdsbmtbtn;
	
	@FindBy(xpath ="//input[@id='passwordResetToken']")
	public WebElement resetpasswordcode;
	
	@FindBy(xpath = "//input[@placeholder='New password']")
	public WebElement newpassword;

	@FindBy(xpath ="//input[@placeholder='Confirm new password']")
	public WebElement confirmpswd;

	@FindBy(xpath ="//span[normalize-space()='Submit']")
	public WebElement passwordresetsbmtbtn;
	
	@FindBy(xpath="//div[@class='content-site-login-return']/a")
	public WebElement returnToTheWebsiteLink;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	public WebElement registerbtn;
	
	@FindBy(xpath="//input[@id='fullname']")
	public WebElement fullName;
	
	@FindBy(xpath="//input[@id='emailAddress']")
	public WebElement emailAddress;
	
	@FindBy(xpath = "//img[@title='Select date']")
	public WebElement datepicker;

	@FindBy(xpath = "//a[normalize-space()='19']")
	public WebElement date;

	@FindBy(xpath = "//select[@aria-label='Select month']")
	public WebElement month;

	@FindBy(xpath = "//select[@aria-label='Select year']")
	public WebElement year;
	
	@FindBy(xpath = "//select[@id='selectedCountryCode']")
	public WebElement country;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement regpassword;

	@FindBy(xpath = "//input[@placeholder='Confirm password']")
	public WebElement confpassword;

	@FindBy(xpath = "//button[@title='Register']")
	public WebElement registerationbtn;
	
	@FindBy(xpath = "//p[contains(text(),'You')]")
	public WebElement text;
	
	@FindBy(xpath="//a[@title='Library card']")
	public WebElement libraryLoginLink;
	
	@FindBy(xpath="//input[@id='library_value']")
	public WebElement findLibrary;
	
	@FindBy(xpath="//div[@class='angucomplete-title ng-binding ng-scope' and normalize-space()='HighWire Press Library']")
	public WebElement selectedLibrary;
	
	@FindBy(xpath ="//input[@id='librarycardinput']")
	public WebElement librarycardnum;
	
	@FindBy(xpath ="//span[normalize-space()='Log in']")
	public WebElement libraryloginbtn;
	
	@FindBy(xpath="//div[@class='institutional-branding__text']")
	public WebElement brandingLogoText;
	
	@FindBy(xpath = "//a[normalize-space()='Redeem a voucher']")
	public WebElement redeemvoucher;
	
	@FindBy(xpath = "//div[@class='alert alert-error alert-active']/p[@class='e2e-error ng-binding']")
	public WebElement vouchertxtmsg;
	
	@FindBy(xpath="//input[@id='voucherCode']")
	public WebElement voucherCode;
	
	@FindBy(xpath="//div[@class='input-block-level submit-area']//button[@class='btn']")
	public WebElement redeemVoucherBtn;
	
	@FindBy(xpath = "//div[@class='input-block-level']//div[@class='help-block ng-binding']")
	public WebElement redeemAlertMsg;
	
	@FindBy(xpath ="//div[@class='access-inner']//a[@title='Login via your institution']")
	public WebElement institutelogin;
	
	@FindBy(xpath="//div[@class='panel-heading']")
	public WebElement sigmaText;
	
	@FindBy(xpath="//input[@id='idpFilterSubstring']")
	public WebElement instituteName;
	
	@FindBy(xpath="//a[normalize-space()='UK federation test IdP']")
	public WebElement selectedInstituteName;

//	WebElement Functions
	
	public void enter_institute_name(String organization) throws InterruptedException {
		instituteName.sendKeys(organization);
		Thread.sleep(3000);
		selectedInstituteName.click();
		log.info("Organization name selected is : "+organization);
	}
	
	public String get_sams_sigma_heading_text() {
		String text = sigmaText.getText();
		return text;
	}
	
	public void click_login_via_your_institution_link() {
		institutelogin.click();
		log.info("Login via your institution link clicked");
	}
	
	public String get_redeem_alert_message_text() {
		String text = redeemAlertMsg.getText();
		return text;
	}
	
	public void click_redeem_voucher_button() {
		redeemVoucherBtn.click();
		log.info("Redeem voucher button clicked ");
	}
	
	public void enter_voucher_code(String vouchercode) {
		voucherCode.sendKeys(vouchercode);
		log.info("Voucher code entered is : "+vouchercode);
	}
	
	public String get_voucher_msg_text() {
		String text = vouchertxtmsg.getText();
		return text;
	}
	
	public void click_redeem_voucher_link() {
		redeemvoucher.click();
		log.info("Redeem voucher link clicked");
	}
		
	public String get_branding_logo_text() {
		String text = brandingLogoText.getText();
		return text;
	}
	
	public void click_library_login_button() {
		libraryloginbtn.click();
		log.info("Login button on Login Via library card clicked");
	}
	
	public void enter_library_card_number(String cardnumber) {
		librarycardnum.sendKeys(cardnumber);
		log.info("Library card number entered is : "+cardnumber);
	}
	
	public void find_your_library(String library) throws InterruptedException {
		findLibrary.sendKeys(library);
		Thread.sleep(3000);
		selectedLibrary.click();
		log.info("Library name selected is : "+library);
	}
	
	public void click_login_via_library_card_link() {
		libraryLoginLink.click();
		log.info("Login via library card link clicked");
	}
	
	public void click_registration_button() {
		registerationbtn.click();
		log.info("Registeration button clicked");
	}
	
	public void enter_registration_password(String password) {
		regpassword.sendKeys(password);
		log.info("Registration password entered is : "+password);
	}
	
	public void enter_confirm_password_for_registration(String confirmpassword) {
		confpassword.sendKeys(confirmpassword);
		log.info("Confirm password entered for registration is :"+confirmpassword);
	}
	
	public void select_country() {
		Select drpcountry = new Select(country);
		drpcountry.selectByValue("IN");
	}
	
	public void select_year() {
		Select drpyear = new Select(year);
		drpyear.selectByValue("1993");
	}
	
	public void select_month() {
		Select drpmonth = new Select(month);
		drpmonth.selectByValue("8");
	}
	
	public void click_date_picker() {
		datepicker.click();
		log.info("Date Picker clicked");
	}
	
	public void select_date() {
		date.click();
		log.info("Date selected ");
	}
	
	public void enter_email_address(String email) {
		emailAddress.sendKeys(email);
		log.info("Email address entered is : "+email);
	}
	
	public void enter_fullname(String fullname) {
		fullName.sendKeys(fullname);
		log.info("Fullname entered is :"+fullname);
	}
	
	public void click_on_register_link()
	{
		registerbtn.click();
		log.info("Register link clicked");
	}
	
	public void click_return_to_the_website_link() {
		returnToTheWebsiteLink.click();
		log.info("Return to the website link clicked");
	}
	
	public void click_reset_password_submit_button() {
		passwordresetsbmtbtn.click();
		log.info("Reset password submit button clicked");
	}
	
	public void enter_new_password(String resetpassword)
	{
		newpassword.sendKeys(resetpassword);
		log.info("New password entered is : "+resetpassword);
	}
	public void enter_confirm_password(String confirmpassword)
	{
		confirmpswd.sendKeys(confirmpassword);
		log.info("Confirm password entered is : "+confirmpassword);
	}
	
	public void enter_reset_password_code(String code) {
		resetpasswordcode.sendKeys(code);
		log.info("Reset password recovery code entered is : "+code);
	}
	
	public void Forgotpasswordemail(String username)
	{
		forgotpasswordemail.sendKeys(username);
		log.info("Recovery email entered is : "+username);
	}
	
	public void click_forgot_password_submit_button() {
		frgtpasswrdsbmtbtn.click();
		log.info("Submit button on forgot password clicked ");
	}
	
	public void click_forgot_password_link() {
		forgotPasswordLink.click();
		log.info("Forgot password link clicked");
	}
	
	public String get_error_toast_message_text() {
		String text= errorToastMsg.getText();
		return text;
	}
	
	public void click_profile_logout_button() {
		profileLogOutBtn.click();
		log.info("Profile logout button clicked");
	}
	
	public String get_user_info_text() {
		String text = userInfo.getText();
		return text;
	}
	
	public void click_logout_button() {
		logOutBtn.click();
		log.info("Logout button clicked");
	}
	
	public String get_my_account_button_text() {
		String text = myAccountBtn.getText();
		return text;
	}
	
	public void click_my_account_button() {
		myAccountBtn.click();
		log.info("My Account button clicked");
	}
	
	public void Username(String username)
	{
		Username.sendKeys(username);
	}

	public void Password(String pwd)
	{
		Password.sendKeys(pwd);    	   
	}

	public void Submitbtn() 
	{
		loginbtn.click();
		log.info("Login button clicked");
	}
	
}
