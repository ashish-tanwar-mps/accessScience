package PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonFunctions;

public class searchObj {

	WebDriver driver ;
	static Logger log = Logger.getLogger(searchObj.class);
	CommonFunctions cmf= new CommonFunctions();

	public searchObj(WebDriver driver )
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//	Web Elements

	@FindBy(xpath="//input[@id='edit-submit-solr-search--2']")
	public WebElement searchBtn;
	
	@FindBy(xpath="//input[@id='edit-query--2']")
	public WebElement searchInputBox;
	
	@FindBy(xpath="//div[@class='search-result-top ']//h2")
	public WebElement searchResultTitle;

	// Web Element Functions
	
	public String get_search_result_title_text() {
		String text = searchResultTitle.getText();
		return text;
	}
	
	public void click_seacrh_button() {
		searchBtn.click();
		log.info("Search button clicked");
	}
	
	public void click_search_input_box() {
		searchInputBox.click();
		log.info("Search Input box clicked");
	}
	
	public void enter_search_term(String searchterm) {
		searchInputBox.sendKeys(searchterm);
		log.info("Search term entered is : "+ searchterm);
	}
}
