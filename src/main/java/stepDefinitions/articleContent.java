package stepDefinitions;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObjects.articleContentObj;
import PageObjects.searchObj;
import io.cucumber.java.en.Then;
import testRailManager.TestRailManager;
import utility.CommonFunctions;
import utility.PropertyFile;
import utility.WebDriverController;

public class articleContent {

	WebDriverController maindriver = new WebDriverController();
	WebDriver driver = maindriver.rdriver();
	articleContentObj acpo = new articleContentObj(driver);
	searchObj spo = new searchObj(driver);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	TestRailManager testrail = new TestRailManager();
	static Logger log = Logger.getLogger(articleContent.class);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	PropertyFile propp = new PropertyFile();
	Properties p = propp.propertyf();
	CommonFunctions cmf= new CommonFunctions();   
	WebElement elm;

	//	Step Definitions

	@Then("user click on searched article {string}")
	public void user_click_on_searched_article (String searchterm) throws InterruptedException {

		try {
			wait.until(ExpectedConditions.visibilityOf(spo.searchResultTitle));	
			String xpath = cmf.create_Xpath("articlePre", searchterm,"postPart");
			log.info(" Xpath is : "+ xpath);
			elm = driver.findElement(By.xpath(xpath));
			jse.executeScript("arguments[0].scrollIntoView(true);",acpo.saveSearchBtn);
			//		Compulsory wait
			Thread.sleep(2000);
			elm.click();
			log.info("Searched article clicked successfully");
			testrail.addResultsToTestrail("Pass", "448459", "Searched article clicked successfully");
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448459", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify article content title with search term {string}")
	public void verify_article_content_title_with_search_term (String searchterm) {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.articleTitle));
			Thread.sleep(2000);
			String actualTitle = acpo.get_artcile_title_text();
			log.info("Actual article title is : " +actualTitle);
			log.info("Expected article title is :"+ searchterm);

			if(actualTitle.equals(searchterm)) {
				System.out.println("Article titles matched");
				log.info("Article titles matched");
				testrail.addResultsToTestrail("Pass", "448460", "Article titles matched");
			}else {
				System.out.println("Article titles not matched");
				log.info("Article titles not matched");
				testrail.addResultsToTestrail("Fail", "448460", "Article titles not matched");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448460", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify author {string}")
	public void verify_author (String authorname1) {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.authorName));
			String actualAuthorName = acpo.get_author_name();
			log.info("Actual Author name : "+actualAuthorName);
			log.info("Expected Author name is : "+ authorname1);

			if(actualAuthorName.contains(authorname1)) {
				System.out.println("Author name matched");
				log.info("Author name matched");
				testrail.addResultsToTestrail("Pass", "448461", "Author name matched");
			}else {
				System.out.println("Author name not matched");
				log.info("Author name not matched");
				testrail.addResultsToTestrail("Fail", "448461", "Author name not matched");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448461", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify the last review date with text {string}")
	public void verify_the_last_review_date_with_text (String lastreview) {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.lastReviewDate));
			String actualtext = acpo.get_last_review_date();
			log.info(" Actual Last review text is  : "+ actualtext);
			log.info("Expected last review text is : "+ lastreview);

			if(actualtext.contains(lastreview)) {
				System.out.println("Last review text matched");
				log.info("Last review text matched");
				testrail.addResultsToTestrail("Pass", "448462", "Last review text matched");
			}else {
				System.out.println("Last review text not matched");
				log.info("Last review text not matched");
				testrail.addResultsToTestrail("Fail", "448462", "Last review text not matched");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448462", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify article DOI link {string}")
	public void verify_article_DOI_link (String doilink) {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.articleDOI));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.articleDOI));
			String actualDOILink = acpo.get_article_doi_link();
			log.info("Actual DOI link is : "+ actualDOILink);
			log.info("Expected DOI Link is : "+ doilink);

			if(actualDOILink.equals(doilink)) {
				System.out.println("DOI Link matched");
				log.info("DOI Link matched");
				testrail.addResultsToTestrail("Pass", "448463", "DOI Link matched");
			}else {
				System.out.println("DOI Link not matched");
				log.info("DOI Link not matched");
				testrail.addResultsToTestrail("Fail", "448463", "DOI Link not matched");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448463", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify show previous version link")
	public void verify_show_previous_version_link() {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.showPreviousVersionLink));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.showPreviousVersionLink));
			acpo.click_show_previous_version_link();

			wait.until(ExpectedConditions.visibilityOf(acpo.hidePreviousVersionLink));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.hidePreviousVersionLink));
			String text = acpo.hidePreviousVersionLink.getAttribute("class");
			log.info("Text is : "+ text);

			int count = acpo.get_previous_version_count();
			log.info("Count of previous versions is : "+ count);

			if(text.contains("collapse")&& count>0 ){
				System.out.println("Previous version link verified");
				log.info("Previous version link verified");
				testrail.addResultsToTestrail("Pass", "448463", "Previous version link verified");
			}else {
				System.out.println("Previous version link not verified");
				log.info("Previous version link not verified");
				testrail.addResultsToTestrail("Fail", "448463", "Previous version link not verified");
			}

			wait.until(ExpectedConditions.visibilityOf(acpo.hidePreviousVersionLink));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.hidePreviousVersionLink));
			acpo.click_hide_previous_version_link();

		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448463", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify Cite section {string}")
	public void verify_Cite_section(String searchterm) {
		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.citeBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.citeBtn));
			acpo.click_cite_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.citeMainTitle));
			String citeMainTitle = acpo.get_cite_main_title();
			log.info("Cite main title is : "+citeMainTitle);

			if(acpo.citeModalTitle.isDisplayed()&&citeMainTitle.contains(searchterm)) {
				System.out.println("Cite section verified");
				log.info("Cite section verified");
				testrail.addResultsToTestrail("Pass", "448464", "Cite section verified");	
			}else {
				System.out.println("Cite section not verified");
				log.info("Cite section not verified");
				testrail.addResultsToTestrail("Fail", "448464", "Cite section not verified");
			}

			wait.until(ExpectedConditions.visibilityOf(acpo.citeModalCloseBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.citeModalCloseBtn));
			acpo.click_cite_modal_close_button();

		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448464", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify Bookmark section {string}")
	public void verify_Bookmark_section (String searchterm) throws InterruptedException {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.bookmarkBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.bookmarkBtn));
			Thread.sleep(2000);
			acpo.click_bookmark_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.bookmarkedBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.bookmarkedBtn));
			if(acpo.bookmarkedBtn.isDisplayed()) {
				System.out.println("Bookmark button working fine");
				log.info("Bookmark button working fine");
				testrail.addResultsToTestrail("Pass", "448469", "Bookmark button working fine");	
			}else {
				System.out.println("Bookmark button not working fine");
				log.info("Bookmark button not working fine");
				testrail.addResultsToTestrail("Fail", "448469", "Bookmark button not working fine");
			}

			wait.until(ExpectedConditions.visibilityOf(acpo.bookmarkedBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.bookmarkedBtn));
			acpo.click_bookmarked_button();

			jse.executeScript("arguments[0].scrollIntoView(true);",acpo.authorName);

			wait.until(ExpectedConditions.visibilityOf(acpo.manageBookmarkBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.manageBookmarkBtn));
			acpo.click_manage_bookmark_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.bookmarkTitle));
			String bookmarkTitle = acpo.get_bookmark_page_title();
			log.info("Bookmark page title is : "+bookmarkTitle);

			wait.until(ExpectedConditions.visibilityOf(acpo.manageBookmarkText));
			String bookmarktext= acpo.get_manage_bookmark_text();
			log.info("bookmark text is : "+bookmarktext);

			if(bookmarkTitle.equals("Bookmarks")&&bookmarktext.equals("Manage your bookmarks.")) {
				System.out.println("Bookmark Page verified");
				log.info("Bookmark Page verified");
				testrail.addResultsToTestrail("Pass", "448476", "Bookmark Page verified");
			}else {
				System.out.println("Bookmark Page not verified");
				log.info("Bookmark Page not verified");
				testrail.addResultsToTestrail("Fail", "448476", "Bookmark Page not verified");
			}

			driver.navigate().back();
			log.info("Back button pressed");
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448469", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify remove bookmark section {string}")
	public void verify_remove_bookmark_section (String searchterm) {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.bookmarkedBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.bookmarkedBtn));
			acpo.click_bookmarked_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.removeBookmarkBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.removeBookmarkBtn));
			acpo.click_remove_bookmark_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.bookmarkBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.bookmarkBtn));
			if(acpo.bookmarkBtn.isDisplayed()) {
				System.out.println("Remove bookmark function verified");
				log.info("Remove bookmark function verified");
				testrail.addResultsToTestrail("Pass", "448484", "Remove bookmark function verified");
			}else {
				System.out.println("Remove bookmark function not verified");
				log.info("Remove bookmark function not verified");
				testrail.addResultsToTestrail("Fail", "448484", "Remove bookmark function not verified");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448484", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify Label dialogue box section")
	public void verify_Label_dialogue_box_section() {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.labelsBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.labelsBtn));
			acpo.click_labels_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.add_removeLabelBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.add_removeLabelBtn));
			acpo.click_add_remove_label_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.labelDialogueTitle));
			String dialogueboxTitle = acpo.get_label_dialogue_title_text();
			log.info("Label dialogue title text is : "+ dialogueboxTitle);

			if(dialogueboxTitle.equals("Add/remove item from label")) {
				System.out.println("Dialogue box title verified");
				log.info("Dialogue box title verified");
				testrail.addResultsToTestrail("Pass", "448485", "Dialogue box title verified");
			}else {
				System.out.println("Dialogue box title not verified");
				log.info("Dialogue box title not verified");
				testrail.addResultsToTestrail("Fail", "448485", "Dialogue box title not verified");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448485", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify add label functionality with {string}")
	public void verify_add_label_functionality_with (String labelname) throws InterruptedException {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.addLabelBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.addLabelBtn));
			acpo.click_add_label_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.labelInputbox));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.labelInputbox));
			acpo.enter_label_name(labelname);

			wait.until(ExpectedConditions.visibilityOf(acpo.addSaveLabelBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.addSaveLabelBtn));
			acpo.click_add_save_label_button();

			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOf(acpo.saveLabelBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.saveLabelBtn));
			acpo.click_save_label_button();

			wait.until(ExpectedConditions.invisibilityOf(acpo.saveLabelBtn));

			wait.until(ExpectedConditions.visibilityOf(acpo.shareBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.shareBtn));

			System.out.println("Test label added with name : "+labelname);
			log.info("Test label added with name : "+labelname);
			testrail.addResultsToTestrail("Pass", "448487", "Test label added");

		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448487", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify manage label functionality with {string}")
	public void verify_manage_label_functionality_with (String labelname) throws InterruptedException {

		try {
			jse.executeScript("arguments[0].scrollIntoView(true);",acpo.authorName);
			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(acpo.labelsBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.labelsBtn));
			acpo.click_labels_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.manageLabelsBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.manageLabelsBtn));
			acpo.click_manage_labels_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.manageLabelIntro));
			wait.until(ExpectedConditions.visibilityOf(acpo.manageLabelAddBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.manageLabelAddBtn));
			Select objSelect = new Select(acpo.labelSortDropdown);
			objSelect.selectByValue("created,desc");
			log.info("Newest first sorting selected");

			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(acpo.selectedLabelText));
			String labelText = acpo.get_selected_label_text();
			log.info("Selected Label text is : "+labelText);

			if(labelText.contains(labelname)) {
				System.out.println("Label text matched");
				log.info("Label text matched");
				testrail.addResultsToTestrail("Pass", "448492", "Label text matched");
			}else {
				System.out.println("Label text not matched");
				log.info("Label text not matched");
				testrail.addResultsToTestrail("Fail", "448492", "Label text not matched");
			}

			wait.until(ExpectedConditions.visibilityOf(acpo.deleteLabelBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.deleteLabelBtn));
			acpo.click_delete_label_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.removeLabelBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.removeLabelBtn));
			acpo.click_remove_label_button();
			testrail.addResultsToTestrail("Pass", "448493", "Manage label functionality is working");

			driver.navigate().back();
			driver.navigate().back();
			log.info("Back button pressed");

		}catch(Exception e) {
			driver.navigate().back();
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448493", "Failed : Due to exception : "+ e);
		}
	}

	@Then("click and verify annotate section {string}")
	public void click_and_verify_annotate_section (String annotatetitle) {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.annotateBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.annotateBtn));
			acpo.click_annotate_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.annotateModalTitle));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.annotateModalTitle));
			String actualTitle = acpo.get_annotate_title_text();
			log.info("Actual annotate title is : "+actualTitle);
			log.info("Expected annotate title is : "+ annotatetitle);

			if(actualTitle.equals(annotatetitle)) {
				System.out.println("Annotate Modal verified ");
				log.info("Annotate Modal verified");
				testrail.addResultsToTestrail("Pass", "448512", "Annotate Modal verified");
			}else {
				System.out.println("Annotate Modal not verified");
				log.info("Annotate Modal not verified");
				testrail.addResultsToTestrail("Fail", "448512", "Annotate Modal not verified");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448512", "Failed : Due to exception : "+ e);
		}
	}

	@Then("close annotate modal")
	public void close_annotate_modal() {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.annotateCloseBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.annotateCloseBtn));
			acpo.click_annotate_close_button();
			testrail.addResultsToTestrail("Pass", "448514", "Annotate modal closed successfully");

		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448514", "Failed : Due to exception : "+ e);
		}
	}

	@Then("user click and verify share button {string}")
	public void user_click_and_verify_share_button(String sharemodaltitle) {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.shareBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.shareBtn));
			acpo.click_share_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.shareModalTitle));
			String title = acpo.get_share_modal_title();
			log.info("Actual modal title is : "+title);
			log.info("Expected modal title is : "+ sharemodaltitle);

			if(title.equals(sharemodaltitle)) {
				System.out.println("Share modal title matched");
				log.info("Share modal title matched");
				testrail.addResultsToTestrail("Pass", "448504", "Share modal title matched");
			}else {
				System.out.println("Share modal title not matched");
				log.info("Share modal title not matched");
				testrail.addResultsToTestrail("Fail", "448504", "Share modal title not matched");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448504", "Failed : Due to exception : "+ e);
		}
	}

	@Then("user click and verify share modal link")
	public void user_click_and_verify_share_modal_link() {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.shareModalLink));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.shareModalLink));
			acpo.click_share_modal_link();

			wait.until(ExpectedConditions.visibilityOf(acpo.shareCopyLink));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.shareCopyLink));
			if(acpo.shareCopyLink.isDisplayed()) {
				System.out.println("Share modal Link verified");
				log.info("Share modal Link verified");
				testrail.addResultsToTestrail("Pass", "448505", "Share modal Link verified");
			}else {
				System.out.println("Share modal Link not verified");
				log.info("Share modal Link not verified");
				testrail.addResultsToTestrail("Fail", "448505", "Share modal Link not verified");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448505", "Failed : Due to exception : "+ e);
		}

	}

	@Then("user verify share link")
	public void user_verify_share_link() {
		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.shareCopyLink));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.shareCopyLink));
			acpo.shareCopyLink.click();

			String actualUrl = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			log.info("URL is : "+actualUrl);

			String currentUrl = driver.getCurrentUrl();
			log.info("Current URL is : "+currentUrl);

			if(currentUrl.contains(actualUrl)) {
				System.out.println("Share URL and current URL matched");
				log.info("Share URL and current URL matched");
				testrail.addResultsToTestrail("Pass", "448511", "Share URL and current URL matched");
			}else {
				System.out.println("Share URL and current URL not matched");
				log.info("Share URL and current URL not matched");
				testrail.addResultsToTestrail("Fail", "448511", "Share URL and current URL not matched");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448511", "Failed : Due to exception : "+ e);
		}
	}

	@Then("close share modal")
	public void close_share_modal() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(acpo.shareModalCloseBtn));
		wait.until(ExpectedConditions.elementToBeClickable(acpo.shareModalCloseBtn));
		acpo.click_share_modal_close_button();
		Thread.sleep(2000);
	}

	@Then("verify share social icon {string}{string}")
	public void verify_share_social_icon(String social,String testcaseid) throws InterruptedException {

		try {
			String xpath = cmf.create_Xpath("shareSocialPre", social, "postPart");
			log.info("Xpath is : "+xpath);

			Thread.sleep(2000);
			elm = driver.findElement(By.xpath(xpath));
			wait.until(ExpectedConditions.visibilityOf(elm));
			wait.until(ExpectedConditions.elementToBeClickable(elm));
			String actualTitle = elm.getAttribute("href");
			log.info("Actual Title is :"+actualTitle);
			log.info("Expected title is : "+social);

			if(actualTitle.contains(social)) {
				System.out.println("Share social media titles matched");
				log.info("Share social media titles matched");
				testrail.addResultsToTestrail("Pass", testcaseid, "Share social media titles matched");
			}else {
				System.out.println("Share social media titles not matched");
				log.info("Share social media titles not matched");
				testrail.addResultsToTestrail("Fail",testcaseid, "Share social media titles not matched");
			}

		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail",testcaseid, "Failed : Due to exception"+e);
		}
	}

	@Then("user click and verify downlaod PDF functionality with {string}")
	public void user_click_and_verify_downlaod_PDF_functionality_with (String pdftitle) {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.downloadpdfBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.downloadpdfBtn));
			acpo.click_download_pdf_button();

			List<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			log.info("Tab switched");

			Thread.sleep(4000);
			String actualTitle = driver.getTitle();
			log.info("URL is : "+driver.getCurrentUrl());
			log.info("Actual title is : "+actualTitle);
			log.info("Expected title is : "+pdftitle);

			if(pdftitle.contains(actualTitle)) {
				System.out.println("PDF titles matched");
				log.info("PDF titles matched");
				testrail.addResultsToTestrail("Pass", "448516", "PDF titles matched");
			}else {
				System.out.println("PDF titles not matched");
				log.info("PDF titles not matched");
				testrail.addResultsToTestrail("Fail", "448516", "PDF titles not matched");
			}

			driver.close();
			driver.switchTo().window(tabs.get(0));
			log.info("Switched back to parent tab");

		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448516", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify readspeaker button")
	public void verify_readspeaker_button() {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.readSpeakerBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.readSpeakerBtn));
			if(acpo.readSpeakerBtn.isDisplayed()) {
				System.out.println("Read speaker button displayed");
				log.info("Read speaker button displayed");
				testrail.addResultsToTestrail("Pass", "448517", "Read speaker button displayed");
			}else {
				System.out.println("Read speaker button not displayed");
				log.info("Read speaker button not displayed");
				testrail.addResultsToTestrail("Fail", "448517", "Read speaker button not displayed");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448517", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify focus view functionality {string}")
	public void verify_focus_view_functionality(String searchterm) {

		try {
			Thread.sleep(2000);	
			jse.executeScript("arguments[0].scrollIntoView(true);",acpo.downloadpdfBtn);
			log.info("Page scrolled");

			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(acpo.focusViewBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.focusViewBtn));
			acpo.click_focus_view_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.focusViewTitle));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.focusViewTitle));
			String actualTitle = acpo.get_focus_view_title();
			log.info("Actual Focus view title is : "+actualTitle);
			log.info("Expected focus view title is : "+searchterm);

			wait.until(ExpectedConditions.visibilityOf(acpo.exitFocusViewBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.exitFocusViewBtn));

			try {
				acpo.actionToolsContainer.isDisplayed();
				log.info("View focus is not working as expected");
			}catch(Exception e){
				if(acpo.exitFocusViewBtn.isDisplayed()&& 
						actualTitle.equals(searchterm)) {
					System.out.println("Focus view button is working");
					log.info("Focus view button is working");
					testrail.addResultsToTestrail("Pass", "448522", "Focus view button is working");
				}else {
					System.out.println("Focus view button is not working");
					log.info("Focus view button is not working");
					testrail.addResultsToTestrail("Fail", "448522", "Focus view button is not working");
				}

				wait.until(ExpectedConditions.visibilityOf(acpo.exitFocusViewBtn));
				wait.until(ExpectedConditions.elementToBeClickable(acpo.exitFocusViewBtn));
				acpo.click_exit_focus_view_button();
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448522", "Failed : Due to exception : "+ e);
		}
	}

	@Then("click and verify table of content")
	public void click_and_verify_table_of_content() {

		try {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(acpo.downloadpdfBtn));
			jse.executeScript("arguments[0].scrollIntoView(true);",acpo.downloadpdfBtn);

			wait.until(ExpectedConditions.visibilityOf(acpo.OpenTOCBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.OpenTOCBtn));
			acpo.click_table_of_content_button();

			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfAllElements(acpo.tocContainer));
			int count = acpo.tocContainer.size();
			log.info("Count of TOC container is : "+count);

			if(acpo.hideTOCBtn.isDisplayed() && count>0 ) {
				System.out.println("Table of content is working");
				log.info("Table of content is working");
				testrail.addResultsToTestrail("Pass", "448525", "Table of content is working");
			}else {
				System.out.println("Table of content is not working");
				log.info("Table of content is not working");
				testrail.addResultsToTestrail("Fail", "448525", "Table of content is not working");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448525", "Failed : Due to exception : "+ e);
		}
	}

	@Then("click and verify table of content element")
	public void click_and_verify_table_of_content_element() {
		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.tocFirstElement));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.tocFirstElement));
			String tocElement = acpo.get_toc_first_element_text();
			log.info("TOC first element is : "+tocElement);

			acpo.click_toc_first_element();

			wait.until(ExpectedConditions.visibilityOf(acpo.tocFirstElementTitle));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.tocFirstElementTitle));
			String tocTitle = acpo.get_toc_first_element_title();
			log.info("TOC first element title is : "+ tocTitle);

			if(tocElement.equals(tocTitle)) {
				System.out.println("Table of content first element verified");
				log.info("Table of content first element verified");
				testrail.addResultsToTestrail("Pass", "448554", "Table of content first element verified");
			}else {
				System.out.println("Table of content first element not verified");
				log.info("Table of content first element not verified");
				testrail.addResultsToTestrail("Fail", "448554", "Table of content first element not verified");
			}	

			wait.until(ExpectedConditions.visibilityOf(acpo.hideTOCBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.hideTOCBtn));
			acpo.click_hide_toc_button();
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448554", "Failed : Due to exception : "+ e);
		}
	}

	@Then("click and verify open in new tab link")
	public void click_and_verify_open_in_new_tab_link() throws InterruptedException {

		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(acpo.elementTitle));
			String titleParentTab = acpo.get_element_title();
			log.info("Element title on parent tab is : "+titleParentTab );

			jse.executeScript("window.scrollBy(0,-250)");

			wait.until(ExpectedConditions.visibilityOf(acpo.openNewTabBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.openNewTabBtn));
			Thread.sleep(2000);
			acpo.click_open_new_tab_link();

			List<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			log.info("Tab switched");

			wait.until(ExpectedConditions.visibilityOf(acpo.elementTitle));
			String titleChildTab = acpo.get_element_title();
			log.info("Element title on child tab is : "+titleChildTab);

			if(titleParentTab.equals(titleChildTab)) {
				System.out.println("Open in new tab functionality verified");
				log.info("Open in new tab functionality verified");
				testrail.addResultsToTestrail("Pass", "448555", "Open in new tab functionality verified");
			}else {
				System.out.println("Open in new tab functionality not verified");
				log.info("Open in new tab functionality not verified");
				testrail.addResultsToTestrail("Fail", "448555", "Open in new tab functionality not verified");
			}		
			driver.close();
			driver.switchTo().window(tabs.get(0));
			log.info("Switched back to parent tab");	
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448555", "Failed : Due to exception : "+ e);
		}
	}

	@Then("click and verify share element in content")
	public void click_and_verify_share_element_in_content() {

		try {
			wait.until(ExpectedConditions.visibilityOf(acpo.shareElementBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.shareElementBtn));
			acpo.click_share_element_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.shareElementCopyLink));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.shareElementCopyLink));
			acpo.click_share_element_copy_link();

			String copyLink = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			log.info("Copy Link URL is : "+copyLink);

			String url = driver.getCurrentUrl();
			log.info("Current URl is : "+url);

			if(copyLink.contains(url)) {
				System.out.println("Share element in content verified");
				log.info("Share element in content verified");
				testrail.addResultsToTestrail("Pass", "448560", "Share element in content verified");
			}else {
				System.out.println("Share element in content not verified");
				log.info("Share element in content not verified");
				testrail.addResultsToTestrail("Fail", "448560", "Share element in content not verified");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448560", "Failed : Due to exception : "+ e);
		}
	}

	@Then("verify related articles {string}{string}{string}{string}{string}")
	public void verify_related_articles(String k1,String k2,String k3,String k4,String k5) throws InterruptedException {

		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(acpo.relatedNewsText));
			jse.executeScript("arguments[0].scrollIntoView(true);",acpo.relatedNewsText);
			log.info("Page scrolled");

			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(acpo.raShowMoreBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.raShowMoreBtn));
			acpo.click_related_article_show_more_button();

			ArrayList<String> a1=new ArrayList<String>();
			ArrayList<String> a3=new ArrayList<String>();
			Collections.addAll(a1, k2,k1,k3,k4,k5);
			Collections.addAll(a3, k2,k1,k3,k4,k5);
			for(String res : a1) {
				log.info("a1: print :" + res);
			}
			ArrayList<String> a2=cmf.user_get_all_link_and_there_title(driver.findElements(By.xpath("//ul//li[@data-type='item_article']//a")));
			for (String resPdf : a2) {
				log.info("a2 print :" + resPdf);					
			}
			a3.removeAll(a2);
			a2.removeAll(a1);
			log.info("a3==="+a3);
			log.info("a2== "+a2);
			if(a2.isEmpty() && a3.isEmpty()) {
				System.out.println("Related articles content verified");
				log.info("Related articles content verified");
				testrail.addResultsToTestrail("Pass", "448588", "Related articles content verified");
			}else {
				System.out.println("Related articles content not verified");
				log.info("Related articles content not verified");
				testrail.addResultsToTestrail("Fail", "448588", "Related articles content not verified");
				log.info("a3==="+a3);
				log.info("a2== "+a2);					
			}			

		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448588", "Failed : Due to exception : "+ e);	
		}
	}

	@Then("verify related news {string}{string}{string}{string}{string}")
	public void verify_related_news(String k1,String k2,String k3,String k4,String k5) throws InterruptedException{

		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(acpo.relatedNewsText));
			jse.executeScript("arguments[0].scrollIntoView(true);",acpo.relatedNewsText);
			log.info("Page scrolled");

			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(acpo.rnShowMoreBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.rnShowMoreBtn));
			acpo.click_related_news_show_more_button();

			ArrayList<String> a1=new ArrayList<String>();
			ArrayList<String> a3=new ArrayList<String>();
			Collections.addAll(a1, k2,k1,k3,k4,k5);
			Collections.addAll(a3, k2,k1,k3,k4,k5);
			for(String res : a1) {
				log.info("a1: print :" + res);
			}
			ArrayList<String> a2=cmf.user_get_all_link_and_there_title(driver.findElements(By.xpath("//div[@class='sidebar sidebar-article']//ul//li[@data-type='item_news' or @data-type='item_briefing']//a")));
			//			ArrayList<String> a4=cmf.user_get_all_link_and_there_title(driver.findElements(By.xpath("//ul//li[@data-type='item_briefing']//a")));
			//			a2.addAll(a4);
			for (String resPdf : a2) {
				log.info("a2 print :" + resPdf);					
			}
			a3.removeAll(a2);
			a2.removeAll(a1);
			log.info("a3==="+a3);
			log.info("a2== "+a2);
			if(a2.isEmpty() && a3.isEmpty()) {
				log.info("Related News content verified");
				System.out.println("Related News content verified");
				testrail.addResultsToTestrail("Pass", "448589", "Related News content verified");
			}else {
				log.info("Related News content not verified");
				System.out.println("Related News content not verified");
				testrail.addResultsToTestrail("Fail", "448589", "Related News content not verified");
				log.info("a3==="+a3);
				log.info("a2== "+a2);					
			}			

		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448589", "Failed : Due to exception : "+ e);	
		}

	} 

	@Then("verify related videos {string}{string}{string}{string}{string}")
	public void verify_related_videos(String k1,String k2,String k3,String k4,String k5) throws InterruptedException {

		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(acpo.relatedVideosText));
			jse.executeScript("arguments[0].scrollIntoView(true);",acpo.relatedVideosText);
			log.info("Page scrolled");

			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(acpo.rvShowMoreBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.rvShowMoreBtn));
			acpo.click_related_videos_show_more_button();

			ArrayList<String> a1=new ArrayList<String>();
			ArrayList<String> a3=new ArrayList<String>();
			Collections.addAll(a1, k2,k1,k3,k4,k5);
			Collections.addAll(a3, k2,k1,k3,k4,k5);
			for(String res : a1) {
				log.info("a1: print :" + res);
			}
			ArrayList<String> a2=cmf.user_get_all_link_and_there_title(driver.findElements(By.xpath("//ul//li[@data-type='item_video']//a")));
			for (String resPdf : a2) {
				log.info("a2 print :" + resPdf);					
			}
			a3.removeAll(a2);
			a2.removeAll(a1);
			log.info("a3==="+a3);
			log.info("a2== "+a2);
			if(a2.isEmpty() && a3.isEmpty()) {
				log.info("Related News content verified");
				System.out.println("Related News content verified");
				testrail.addResultsToTestrail("Pass", "448590", "Related News content verified");
			}else {
				log.info("Related News content not verified");
				System.out.println("Related News content not verified");
				testrail.addResultsToTestrail("Fail", "448590", "Related News content not verified");
				log.info("a3==="+a3);
				log.info("a2== "+a2);					
			}			

		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448590", "Failed : Due to exception : "+ e);	
		}

	}

	@Then("verify related book chapters {string}{string}{string}{string}{string}")
	public void verify_related_book_chapters(String k1,String k2,String k3,String k4,String k5) throws InterruptedException {

		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(acpo.relatedBookChaptersText));
			jse.executeScript("arguments[0].scrollIntoView(true);",acpo.relatedBookChaptersText);
			log.info("Page scrolled");

			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(acpo.rbcShowMoreBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.rbcShowMoreBtn));
			acpo.click_related_book_chapters_show_more_button();

			ArrayList<String> a1=new ArrayList<String>();
			ArrayList<String> a3=new ArrayList<String>();
			Collections.addAll(a1, k2,k1,k3,k4,k5);
			Collections.addAll(a3, k2,k1,k3,k4,k5);
			for(String res : a1) {
				log.info("a1: print :" + res);
			}
			ArrayList<String> a2=cmf.user_get_all_link_and_there_title(driver.findElements(By.xpath("//ul//li[@data-type='item_chapter']//a")));
			for (String resPdf : a2) {
				log.info("a2 print :" + resPdf);					
			}
			a3.removeAll(a2);
			a2.removeAll(a1);
			log.info("a3==="+a3);
			log.info("a2== "+a2);
			if(a2.isEmpty() && a3.isEmpty()) {
				log.info("Related Book chapters content verified");
				System.out.println("Related Book chapters content verified");
				testrail.addResultsToTestrail("Pass", "448591", "Related Book chapters content verified");
			}else {
				log.info("Related Book chapters content not verified");
				System.out.println("Related Book chapters content not verified");
				testrail.addResultsToTestrail("Fail", "448591", "Related Book chapters content not verified");
				log.info("a3==="+a3);
				log.info("a2== "+a2);					
			}			

		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448591", "Failed : Due to exception : "+ e);	
		}
	}

	@Then("verify content in Topic section {string}{string}{string}{string}")
	public void verify_content_in_Topic_section (String k1,String k2,String k3,String k4) throws InterruptedException {

		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(acpo.topicsText));
			jse.executeScript("arguments[0].scrollIntoView(true);",acpo.topicsText);
			log.info("Page scrolled");

			Thread.sleep(2000);

			ArrayList<String> a1=new ArrayList<String>();
			ArrayList<String> a3=new ArrayList<String>();
			Collections.addAll(a1, k2,k1,k3,k4);
			Collections.addAll(a3, k2,k1,k3,k4);
			for(String res : a1) {
				log.info("a1: print :" + res);
			}
			ArrayList<String> a2=cmf.user_get_all_link_and_there_title(driver.findElements(By.xpath("//ul//li[@data-type='mheas-taxonomy-terms']//a")));
			for (String resPdf : a2) {
				log.info("a2 print :" + resPdf);					
			}
			a3.removeAll(a2);
			a2.removeAll(a1);
			log.info("a3==="+a3);
			log.info("a2== "+a2);
			if(a2.isEmpty() && a3.isEmpty()) {
				log.info("Content in Topic section verified");
				System.out.println("Content in Topic section verified");
				testrail.addResultsToTestrail("Pass", "448591", "Content in Topic section verified");
			}else {
				log.info("Content in Topic section not verified");
				System.out.println("Content in Topic section not verified");
				testrail.addResultsToTestrail("Fail", "448591", "Content in Topic section not verified");
				log.info("a3==="+a3);
				log.info("a2== "+a2);					
			}			
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448591", "Failed : Due to exception : "+ e);	
		}
	}

	@Then("verify figures and tables label")
	public void verify_figures_and_tables_label() throws InterruptedException{

		try {

			jse.executeScript("arguments[0].scrollIntoView(true);",acpo.articleTitle);

			Actions action = new Actions(driver);
			//		action.moveToElement(acpo.figuresTableslabelBtn).click();
			action.moveToElement(acpo.figuresTableslabelBtn);
			log.info("Clicked ");

			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(acpo.figuresTableslabelBtn));
			wait.until(ExpectedConditions.elementToBeClickable(acpo.figuresTableslabelBtn));
			acpo.click_figures_tables_labels_button();

			wait.until(ExpectedConditions.visibilityOf(acpo.figuresTableslabelBtn));
			String labelText = acpo.figuresTableslabelBtn.getText();
			log.info("Label text is : "+labelText);

			wait.until(ExpectedConditions.visibilityOf(acpo.figuresText));
			String text = acpo.figuresText.getText();
			log.info("Text is : "+text);

			if(labelText.contains(text)) {
				log.info("Figures and Tables Label verified");
				System.out.println("Figures and Tables Label verified");
				testrail.addResultsToTestrail("Pass", "448594", "Figures and Tables Label verified");
			}else {
				log.info("Figures and Tables Label not verified");
				System.out.println("Figures and Tables Label not verified");
				testrail.addResultsToTestrail("Fail", "448594", "Figures and Tables Label not verified");
			}
		}catch(Exception e) {
			log.info("Failed : Due to exception" + e);
			testrail.addResultsToTestrail("Fail", "448591", "Failed : Due to exception : "+ e);	
		}
	}

	@Then("verify primary literature label")
	public void verify_primary_literature_label() {

		wait.until(ExpectedConditions.visibilityOf(acpo.primaryLiteratureLabel));
		wait.until(ExpectedConditions.elementToBeClickable(acpo.primaryLiteratureLabel));
		acpo.click_primary_literature_label();

		wait.until(ExpectedConditions.visibilityOf(acpo.primaryLiteratureData));
		wait.until(ExpectedConditions.elementToBeClickable(acpo.primaryLiteratureData));
		if(acpo.primaryLiteratureData.isDisplayed()) {
			log.info("Primary Literature Label verified");
			System.out.println("Primary Literature Label verified");
			testrail.addResultsToTestrail("Pass", "448595", "Primary Literature Label verified");
		}else {
			log.info("Primary Literature Label not verified");
			System.out.println("Primary Literature Label not verified");
			testrail.addResultsToTestrail("Fail", "448595", "Primary Literature Label not verified");
		}
	}

	@Then("verify self test section")
	public void verify_self_test_section() {

		wait.until(ExpectedConditions.visibilityOf(acpo.primaryLiteratureLabel));
		wait.until(ExpectedConditions.elementToBeClickable(acpo.primaryLiteratureLabel));
		acpo.click_self_test_button();
	}
	
}

