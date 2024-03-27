package PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utility.CommonFunctions;

public class biographyContentObj {

	WebDriver driver ;
	static Logger log = Logger.getLogger(biographyContentObj.class);
	CommonFunctions cmf= new CommonFunctions();

	public biographyContentObj(WebDriver driver )
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//	Web Elements
	
	
}
