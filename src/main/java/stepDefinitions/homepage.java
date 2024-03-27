package stepDefinitions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.LoginPgObj;
import PageObjects.homepageObj;
import io.cucumber.java.en.Then;
import testRailManager.TestRailManager;
import utility.CommonFunctions;
import utility.PropertyFile;
import utility.WebDriverController;

public class homepage {

	WebDriverController maindriver = new WebDriverController();
	WebDriver driver = maindriver.rdriver();
	homepageObj hpo = new homepageObj(driver);
	LoginPgObj lpo = new LoginPgObj(driver);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	TestRailManager testrail = new TestRailManager();
	static Logger log = Logger.getLogger(homepage.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	PropertyFile propp = new PropertyFile();
	Properties p = propp.propertyf();
	CommonFunctions cmf= new CommonFunctions();   
	WebElement elm;

	//	Step Definitions

	@Then("verify access science homepage with page title {string}")
	public void verify_access_science_homepage_with_page_title (String pagetitle) {
		try {
			wait.until(ExpectedConditions.titleContains(pagetitle));
			String actualPageTitle = driver.getTitle();
			log.info("Expected page title is : "+pagetitle);
			log.info("Actual page title is : "+actualPageTitle);

			if (pagetitle.equals(actualPageTitle)) {
				System.out.println("Page title matched");
				log.info("Page title matched");
				testrail.addResultsToTestrail("Pass", "448401", "Page title matched");
			}else {
				System.out.println("Page title not matched");
				log.info("Page title not matched");
				testrail.addResultsToTestrail("Fail", "448401", "Page title not matched");
			}
		}
		catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448401", "Failed : Due to exception"+e);
		}
	}

	@Then("verify text for content button {string}")
	public void verify_text_for_content_button (String contenttext) {

		try {
			wait.until(ExpectedConditions.visibilityOf(hpo.contentBtn));
			wait.until(ExpectedConditions.elementToBeClickable(hpo.contentBtn));
			String actualText= hpo.get_content_button_text();
			log.info("Actual button text is : "+actualText);
			log.info("Expected text is : "+contenttext);

			if(actualText.equals(contenttext)) {
				System.out.println("Content button text matched");
				log.info("Content button text matched");
				testrail.addResultsToTestrail("Pass", "448412", "Content button text matched");
			}else {
				System.out.println("Content button text not matched");
				log.info("Content button text not matched");
				testrail.addResultsToTestrail("Fail", "448412", "Content button text not matched");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448412", "Failed : Due to exception"+e);
		}
	}

	@Then("verify the drop down menu in content section")
	public void verify_the_drop_down_menu_in_content_section() throws InterruptedException {

		try {
			wait.until(ExpectedConditions.visibilityOf(hpo.contentBtn));
			wait.until(ExpectedConditions.elementToBeClickable(hpo.contentBtn));
			hpo.click_content_button();
			wait.until(ExpectedConditions.visibilityOfAllElements(hpo.contentDropdownContainer));
			cmf.user_get_link_and_there_title_of_page(hpo.contentDropdownContainer);
			testrail.addResultsToTestrail("Pass", "448453", "Content Dropdown is Exapndable");
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
            testrail.addResultsToTestrail("Fail", "448453", "Content Dropdown is not Exapndable"+e);
		}
	}

	@Then("verify the link in dropdown menu {string}{string}")
	public void verify_the_link_in_dropdown_menu (String text,String testcaseid) {

		try {
			String xpath = cmf.create_Xpath("dropdownPre",text,"dropdownPost");
			log.info("Xapth is : "+ xpath);
			elm = driver.findElement(By.xpath(xpath));
			String actualText = elm.getText();
			log.info("Actual text is : "+actualText);
			log.info("Expected text is : "+ text);

			if(actualText.equals(text)) {
				System.out.println("Dropdown link "+text+ " matched");
				log.info("Drodown link "+text+ " matched");
				testrail.addResultsToTestrail("Pass", testcaseid, "Dropdown link "+text+ " matched");
			}else {
				System.out.println("Dropdown link "+text+ " not matched");
				log.info("Dropdown link "+text+ " not matched");
				testrail.addResultsToTestrail("Fail", testcaseid, "Dropdown link "+text+ " not matched");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail",testcaseid, "Failed : Due to exception"+e);
		}
	}

	@Then("verify the link in Information For section {string}")
	public void verify_the_link_in_Information_For_section (String text) {


	} 

	@Then("verify text for topics button {string}")
	public void verify_text_for_topics_button (String topicstext) {

		try {
			wait.until(ExpectedConditions.visibilityOf(hpo.topicsBtn));
			wait.until(ExpectedConditions.elementToBeClickable(hpo.topicsBtn));
			String actualText= hpo.get_topic_button_text();
			log.info("Actual button text is : "+actualText);
			log.info("Expected text is : "+topicstext);

			if(actualText.equals(topicstext)) {
				System.out.println("Topics button text matched");
				log.info("Topics button text matched");
				testrail.addResultsToTestrail("Pass", "448418", "Topics button text matched");
			}else {
				System.out.println("Topics button text not matched");
				log.info("Topics button text not matched");
				testrail.addResultsToTestrail("Fail", "448418", "Topics button text not matched");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail","448418", "Failed : Due to exception"+e);
		}
	}

	@Then("verify text for information for button {string}")
	public void verify_text_for_information_for_button (String informationfortext) {

		try {
			wait.until(ExpectedConditions.visibilityOf(hpo.informationForBtn));
			wait.until(ExpectedConditions.elementToBeClickable(hpo.informationForBtn));
			String actualText= hpo.get_information_for_button_text();
			log.info("Actual button text is : "+actualText);
			log.info("Expected text is : "+informationfortext);

			if(actualText.equals(informationfortext)) {
				System.out.println("Information For button text matched");
				log.info("Information For button text matched");
				testrail.addResultsToTestrail("Pass", "448419", "Information For button text matched");
			}else {
				System.out.println("Information For button text not matched");
				log.info("Information For button text not matched");
				testrail.addResultsToTestrail("Fail", "448419", "Information For button text not matched");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail","448419", "Failed : Due to exception"+e);
		}
	}

	@Then("verify the drop down menu in Information For section")
	public void verify_the_drop_down_menu_in_Information_For_section() throws InterruptedException {

		try {
			wait.until(ExpectedConditions.visibilityOf(hpo.informationForBtn));
			wait.until(ExpectedConditions.elementToBeClickable(hpo.informationForBtn));
			hpo.click_information_for_button();
			wait.until(ExpectedConditions.visibilityOfAllElements(hpo.informationDropdownContainer));
			cmf.user_get_link_and_there_title_of_page(hpo.informationDropdownContainer);
			testrail.addResultsToTestrail("Pass", "448454", "Information For Drop down is expandable");
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail","448454", "Information For Drop down is not expandable "+ e);
		}
	}

	@Then("verify text for my account button {string}")
	public void verify_text_for_my_account_button (String myaccounttext) {

		try {
			wait.until(ExpectedConditions.visibilityOf(lpo.myAccountBtn));
			wait.until(ExpectedConditions.elementToBeClickable(lpo.myAccountBtn));
			String actualText= lpo.get_my_account_button_text();
			log.info("Actual button text is : "+actualText);
			log.info("Expected text is : "+myaccounttext);

			if(actualText.equals(myaccounttext)) {
				System.out.println("My Account button text matched");
				log.info("My Account button text matched");
				testrail.addResultsToTestrail("Pass", "448423", "My Account button text matched");
			}else {
				System.out.println("My Account button text not matched");
				log.info("My Account button text not matched");
				testrail.addResultsToTestrail("Fail", "448423", "My Account button text not matched");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail","448423", "Failed : Due to exception"+e);
		}
	}

	@Then("print the list of content in the container")
	public void print_the_list_of_content_in_the_container() throws InterruptedException {

		try {
			cmf.user_get_link_and_there_title_of_page(hpo.cardContainer);
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			//			testrail.addResultsToTestrail("Fail","448423", "Failed : Due to exception"+e);
		}
	}

	@Then("verify the Content footer links {string}") 
	public void verify_the_Content_footer_links(String text) throws InterruptedException {

		String xpath = cmf.create_Xpath("footerContentPre",text,"footerContentPost");
		log.info("Xapth is : "+ xpath);
		elm = driver.findElement(By.xpath(xpath));
		String actualText = elm.getText();
		log.info("Actual text is : "+actualText);
		log.info("Expected text is : "+ text);

		if(actualText.equals(text)) {
			System.out.println("Content footer link "+text+ " matched");
			log.info("Content footer link "+text+ " matched");
			// testrail.addResultsToTestrail("pass", "446672", "Content footer link "+text+ " matched");
		}else {
			System.out.println("Content footer link "+text+ " not matched");
			log.info("Content footer link "+text+ " not matched");
			// testrail.addResultsToTestrail("fail", "446672", "Content footer link "+text+ " not matched");
		}
	}

	@Then("verify the footer links{string}{string}{string}")
	public void verify_the_footer_links(String type,String text,String testcaseid) {

		try {
			String xpath = cmf.create_footer_xpath("footerPre", type, "footerMid", text, "footerPost");
			log.info("Xpath is : "+xpath);

			elm = driver.findElement(By.xpath(xpath));
			String actualText = elm.getText();
			log.info("Actual footer text is : "+actualText);
			log.info("Expected footer text is : "+ text);

			if(actualText.equals(text)) {
				System.out.println("Footer link "+text+ " matched");
				log.info("Footer link "+text+ " matched");
				testrail.addResultsToTestrail("Pass", testcaseid, "Footer link "+text+ " matched");
			}else {
				System.out.println("Footer link "+text+ " not matched");
				log.info("Footer link "+text+ " not matched");
				testrail.addResultsToTestrail("Fail",testcaseid, "Footer link "+text+ " not matched");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail",testcaseid, "Failed : Due to exception"+e);
		}
	}

	@Then("verify social media icons {string}{string}")
	public void verify_social_media_icons (String social,String testcaseid) {

		try {
			String xpath = cmf.create_Xpath("socialPre", social, "postPart");
			log.info("Xpath is : "+xpath);

			elm = driver.findElement(By.xpath(xpath));
			wait.until(ExpectedConditions.visibilityOf(elm));
			wait.until(ExpectedConditions.elementToBeClickable(elm));
			String actualTitle = elm.getAttribute("title");
			log.info("Actual Title is :"+actualTitle);
			log.info("Expected title is : "+social);

			if(actualTitle.equals(social)) {
				System.out.println("Social media titles matched");
				log.info("Social media titles matched");
				testrail.addResultsToTestrail("Pass", testcaseid, "Social media titles matched");
			}else {
				System.out.println("Social media titles not matched");
				log.info("Social media titles not matched");
				testrail.addResultsToTestrail("Fail",testcaseid, "Social media titles not matched");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail",testcaseid, "Failed : Due to exception"+e);
		}
	}

	@Then("verify the user IP Address {string}")
	public void verify_the_user_IP_Address (String ipaddress) {

		try {
			String actualIP = hpo.get_user_IP_Address();
			log.info("Actual IP Address : "+actualIP);
			log.info("Expected IP Address :"+ipaddress);

			if(actualIP.contains(ipaddress)) {
				System.out.println("IP Address verified");
				log.info("IP Address verified");
				testrail.addResultsToTestrail("Pass", "448441", "IP Address verified");
			}else {
				System.out.println("IP Address not verified");
				log.info("IP Address not verified");
				testrail.addResultsToTestrail("Fail", "448441", "IP Address not verified");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail","448441", "Failed : Due to exception"+e);
		}
	}

	@Then("verify Privacy Notice Link with title {string}")
	public void verify_Privacy_Notice_Link_with_title(String privacytitle) {
		try {
			jse.executeScript("arguments[0].scrollIntoView(true);", hpo.privacyNoticeLink);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(hpo.privacyNoticeLink));
			wait.until(ExpectedConditions.elementToBeClickable(hpo.privacyNoticeLink));
			String expectedUrl = hpo.privacyNoticeLink.getAttribute("href");
			hpo.click_privavy_notice_link();

			wait.until(ExpectedConditions.visibilityOf(hpo.privacyTitle));
			String actualTitle = hpo.get_privacy_page_title();
			String actualUrl = driver.getCurrentUrl();
			log.info("Expected URL is :" + expectedUrl);
			log.info("Actual URL is : "+ actualUrl);
			log.info("Actual title is : "+actualTitle);
			log.info("Expected title is : "+privacytitle);

			if(actualTitle.equals(privacytitle)&& actualUrl.equals(expectedUrl)) {
				System.out.println("Privacy Link verified");
				log.info("Privacy Link verified");
				testrail.addResultsToTestrail("Pass", "448442", "Privacy Link verified");
			}else {
				System.out.println("Privacy Link not verified");
				log.info("Privacy Link not verified");
				testrail.addResultsToTestrail("Fail", "448442", "Privacy Link not verified");
			}
			driver.navigate().back();
			log.info("Back button pressed");
		}catch(Exception e) {
			log.info("Failed : Due to exception : " + e);
			testrail.addResultsToTestrail("Fail","448442", "Failed : Due to exception"+e);
		}
	}

	@Then("verify Terms of use Link with title {string}")
	public void verify_Terms_of_use_Link_with_title(String termsofusetitle) {

		try {
			wait.until(ExpectedConditions.visibilityOf(hpo.termsOfUseLink));
			wait.until(ExpectedConditions.elementToBeClickable(hpo.termsOfUseLink));
			String expectedUrl = hpo.termsOfUseLink.getAttribute("href");
			hpo.click_terms_of_use_link();

			wait.until(ExpectedConditions.visibilityOf(hpo.termsOfUseTitle));
			String actualTitle = hpo.get_terms_of_use_title();
			String actualUrl = driver.getCurrentUrl();
			log.info("Expected URL is :" + expectedUrl);
			log.info("Actual URL is : "+ actualUrl);
			log.info("Actual title is : "+actualTitle);
			log.info("Expected title is : "+termsofusetitle);

			if(actualTitle.equals(termsofusetitle)&& actualUrl.equals(expectedUrl)) {
				System.out.println("Terms of Use link verified");
				log.info("Terms of Use link verified");
				testrail.addResultsToTestrail("Pass", "448447", "Terms of Use link verified");
			}else {
				System.out.println("Terms of Use link not verified");
				log.info("Terms of Use link not verified");
				testrail.addResultsToTestrail("Fail", "448447", "Terms of Use link not verified");
			}
			driver.navigate().back();
			log.info("Back button pressed");
		}catch(Exception e) {
			log.info("Failed : Due to exception : " + e);
			testrail.addResultsToTestrail("Fail","448447", "Failed : Due to exception"+e);
		}
	}

	@Then("verify Additional Credits and copyrights Link with title {string}")
	public void verify_Additional_Credits_and_copyrights_Link_with_title (String copyrighttitle) {
		try {
			wait.until(ExpectedConditions.visibilityOf(hpo.copyrightLink));
			wait.until(ExpectedConditions.elementToBeClickable(hpo.copyrightLink));
			String expectedUrl = hpo.copyrightLink.getAttribute("href");
			hpo.click_copyright_link();

			wait.until(ExpectedConditions.visibilityOf(hpo.copyrightTitle));
			String actualTitle = hpo.get_copyright_title();
			String actualUrl = driver.getCurrentUrl();
			log.info("Expected URL is :" + expectedUrl);
			log.info("Actual URL is : "+ actualUrl);
			log.info("Actual title is : "+actualTitle);
			log.info("Expected title is : "+copyrighttitle);

			if(actualTitle.equals(copyrighttitle)&& actualUrl.equals(expectedUrl)) {
				System.out.println("Additional credits and copyrights link verified");
				log.info("Additional credits and copyrights link verified");
				testrail.addResultsToTestrail("Pass", "448448", "Additional credits and copyrights link verified");
			}else {
				System.out.println("Additional credits and copyrights link not verified");
				log.info("Additional credits and copyrights link not verified");
				testrail.addResultsToTestrail("Fail", "448448", "Additional credits and copyrights link not verified");
			}
			driver.navigate().back();
			log.info("Back button pressed");
		}catch(Exception e) {
			log.info("Failed : Due to exception : " + e);
			testrail.addResultsToTestrail("Fail","448448", "Failed : Due to exception"+e);
		}
	}

	@Then("verify Accessibility Policy link with title {string}")
	public void verify_Accessibility_Policy_link_with_title (String accessibilitypolicytitle) throws InterruptedException {
		try {
			wait.until(ExpectedConditions.visibilityOf(hpo.accessibilityPolicyLink));
			wait.until(ExpectedConditions.elementToBeClickable(hpo.accessibilityPolicyLink));
			String expectedUrl = hpo.accessibilityPolicyLink.getAttribute("href");
			hpo.click_accessibility_link();

			Thread.sleep(2000);

			List<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			log.info("Tab switched");

			wait.until(ExpectedConditions.visibilityOf(hpo.accessibilityTitle));
			String actualTitle = hpo.get_accessibility_title();
			String actualUrl = driver.getCurrentUrl();
			log.info("Expected URL is :" + expectedUrl);
			log.info("Actual URL is : "+ actualUrl);
			log.info("Actual title is : "+actualTitle);
			log.info("Expected title is : "+accessibilitypolicytitle);

			if(actualTitle.equals(accessibilitypolicytitle)&& actualUrl.equals(expectedUrl)) {
				System.out.println("Accessibility Policy link verified");
				log.info("Accessibility Policy link verified");
				testrail.addResultsToTestrail("Pass", "448449", "Accessibility Policy link verified");
			}else {
				System.out.println("Accessibility Policy link not verified");
				log.info("Accessibility Policy link not verified");
				testrail.addResultsToTestrail("Fail", "448449", "Accessibility Policy link not verified");
			}
			driver.quit();
			log.info("All drivers closed");
		}catch(Exception e) {
			log.info("Failed : Due to exception : " + e);
			testrail.addResultsToTestrail("Fail","448449", "Failed : Due to exception"+e);
		}
	}
}
