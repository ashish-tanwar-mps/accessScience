package stepDefinitions;

import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObjects.searchObj;
import io.cucumber.java.en.Then;
import testRailManager.TestRailManager;
import utility.CommonFunctions;
import utility.PropertyFile;
import utility.WebDriverController;

public class search {

	WebDriverController maindriver = new WebDriverController();
	WebDriver driver = maindriver.rdriver();
	searchObj spo = new searchObj(driver);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	TestRailManager testrail = new TestRailManager();
	static Logger log = Logger.getLogger(search.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	PropertyFile propp = new PropertyFile();
	Properties p = propp.propertyf();
	CommonFunctions cmf= new CommonFunctions();   
	WebElement elm;

	//	Step Definitions

	@Then("user click on search input box")
	public void user_click_on_search_input_box() {

		try {
			wait.until(ExpectedConditions.visibilityOf(spo.searchInputBox));
			wait.until(ExpectedConditions.elementToBeClickable(spo.searchInputBox));
			spo.click_search_input_box();
			testrail.addResultsToTestrail("Pass","448455", "Search input box clicked successfully");
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448455", "Failed : Due to exception"+e);
		}
	}

	@Then("user enter search term {string}")
	public void user_enter_search_term (String searchterm) {

		try {
			wait.until(ExpectedConditions.visibilityOf(spo.searchInputBox));
			wait.until(ExpectedConditions.elementToBeClickable(spo.searchInputBox));
			spo.enter_search_term(searchterm);
			testrail.addResultsToTestrail("Pass","448456", "Search term entered successfully is :"+searchterm);
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448456", "Failed : Due to exception"+e);
		}
	}

	@Then("user click on search button")
	public void user_click_on_search_button() {

		try {
			wait.until(ExpectedConditions.visibilityOf(spo.searchBtn));
			wait.until(ExpectedConditions.elementToBeClickable(spo.searchBtn));
			spo.click_seacrh_button();
			testrail.addResultsToTestrail("Pass","448457", "Search button clicked successfully");
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448457", "Failed : Due to exception"+e);
		}
	}

	@Then("verify search result title with search term {string}")
	public void verify_search_result_title_with_search_term (String searchterm) {

		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(spo.searchResultTitle));
			String actualText = spo.get_search_result_title_text();
			log.info("Expected Search result title is : "+searchterm);
			log.info("Actual Search result title is : "+ actualText);

			if(actualText.contains(searchterm)) {
				System.out.println("Search result verified");
				log.info("Search result verified");
				testrail.addResultsToTestrail("Pass","448458", "Search result verified");
			}else {
				System.out.println("Search result not verified");
				log.info("Search result not verified");
				testrail.addResultsToTestrail("Fail","448458", "Search result not verified");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448458", "Failed : Due to exception"+e);
		}
	}

}
