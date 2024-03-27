package PageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonFunctions;

public class homepageObj {

	WebDriver driver ;
	static Logger log = Logger.getLogger(homepageObj.class);
	CommonFunctions cmf= new CommonFunctions();

	public homepageObj(WebDriver driver )
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//	Web Elements

	@FindBy(xpath="//a[@class='dropdown-toggle navigation__item__toggle'][normalize-space()='Content']")
	public WebElement contentBtn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu navigation__item__dropdown-menu show']")
	public List<WebElement> contentDropdownContainer;

	@FindBy(xpath="//a[@class='nav-link'][normalize-space()='Topics']")
	public WebElement topicsBtn;

	@FindBy(xpath= "//a[@class='dropdown-toggle navigation__item__toggle'][normalize-space()='Information for']")
	public WebElement informationForBtn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu navigation__item__dropdown-menu show']")
	public List<WebElement> informationDropdownContainer;

	@FindBy(xpath="//a[@class='nav-link'][normalize-space()='About']")
	public WebElement aboutBtn;
	
	@FindBy(xpath="//div[@class='container content-list-block']")
	public List<WebElement> cardContainer;
	
	@FindBy(xpath="//li[@class='first']//a[normalize-space()='Articles']")
	public WebElement footerArticleLink;
	
	@FindBy(xpath="//p[@class='footer-ipaddress']")
	public WebElement footerIpAddress;
	
	@FindBy(xpath="//div[@class='block-content']//a[@title='Privacy']")
	public WebElement privacyNoticeLink;
	
	@FindBy(xpath="//div[@id='text-505969f7f2']//span[@class='text-white']")
	public WebElement privacyTitle;
	
	@FindBy(xpath="//div[@class='block-content']//a[@title='Terms of Use']")
	public WebElement termsOfUseLink;
	
	@FindBy(xpath="//h2[@class='title-main']")
	public WebElement termsOfUseTitle;
	
	@FindBy(xpath="//div[@class='block-content']//a[@title='Copyright Information']")
	public WebElement copyrightLink;
	
	@FindBy(xpath="//h2[@class='title-main']")
	public WebElement copyrightTitle;
	
	@FindBy(xpath="//div[@class='block-content']//a[@title='Accessibility policy']")
	public WebElement accessibilityPolicyLink;
	
	@FindBy(xpath="//h1//span[@class='text-white']")
	public WebElement accessibilityTitle;

	//	WebElement Functions
	
	public void click_accessibility_link() {
		accessibilityPolicyLink.click();
		log.info("Accessibility policy Link clicked");
	}
	
	public String get_accessibility_title() {
		String title = accessibilityTitle.getText();
		return title;
	}
	
	public void click_copyright_link() {
		copyrightLink.click();
		log.info("Additional credits and Copyright Link clicked");
	}
	
	public String get_copyright_title() {
		String title = copyrightTitle.getText();
		return title;
	}
	
	public String get_terms_of_use_title() {
		String title = termsOfUseTitle.getText();
		return title;
	}
	
	public void click_terms_of_use_link() {
		termsOfUseLink.click();
		log.info("Terms of Use Link clicked");
	}
	
	public String get_privacy_page_title() {
		String title = privacyTitle.getText();
		return title;
	}
	
	public void click_privavy_notice_link() {
		privacyNoticeLink.click();
		log.info("Privacy Notice Link clicked");
	}
	
	public String get_user_IP_Address() {
		String text = footerIpAddress.getText();
		return text;
	}
	
	public String get_content_button_text() {
		String text = contentBtn.getText();
		return text;
	}

	public void click_content_button() {
		contentBtn.click();
		log.info("Content button clicked");
	}

	public String get_topic_button_text() {
		String text = topicsBtn.getText();
		return text;
	}

	public void click_topic_button() {
		topicsBtn.click();
		log.info("Topics button clicked");
	}

	public String get_information_for_button_text() {
		String text = informationForBtn.getText();
		return text;
	}

	public void click_information_for_button() {
		informationForBtn.click();
		log.info("Information for button clicked");
	}

	public String get_about_for_button_text() {
		String text = aboutBtn.getText();
		return text;
	}

	public void click_about_button() {
		aboutBtn.click();
		log.info("About button clicked");
	}
}
