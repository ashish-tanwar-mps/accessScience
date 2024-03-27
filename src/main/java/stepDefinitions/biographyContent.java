package stepDefinitions;

import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.biographyContentObj;
import PageObjects.searchObj;
import testRailManager.TestRailManager;
import utility.CommonFunctions;
import utility.PropertyFile;
import utility.WebDriverController;

public class biographyContent {
	
	WebDriverController maindriver = new WebDriverController();
	WebDriver driver = maindriver.rdriver();
	biographyContentObj acpo = new biographyContentObj(driver);
	searchObj spo = new searchObj(driver);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	TestRailManager testrail = new TestRailManager();
	static Logger log = Logger.getLogger(biographyContent.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	PropertyFile propp = new PropertyFile();
	Properties p = propp.propertyf();
	CommonFunctions cmf= new CommonFunctions();   
	WebElement elm;

	//	Step Definitions

}
