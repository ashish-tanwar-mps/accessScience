package PageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonFunctions;

public class articleContentObj {

	WebDriver driver ;
	static Logger log = Logger.getLogger(articleContentObj.class);
	CommonFunctions cmf= new CommonFunctions();

	public articleContentObj(WebDriver driver )
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//	Web Elements

	@FindBy(xpath="//a[@id='highwire-personalization-dropdown-title']")
	public WebElement saveSearchBtn;

	@FindBy(xpath="//h2[@class='title-main']")
	public WebElement articleTitle;

	@FindBy(xpath="//div[@class='article__authorname']")
	public WebElement authorName;

	@FindBy(xpath="//span[@class='article-last-review']")
	public WebElement lastReviewDate;

	@FindBy(xpath="//div[@class='article__doi']")
	public WebElement articleDOI;

	@FindBy(xpath="//span[@class='expand-content']")
	public WebElement showPreviousVersionLink;

	@FindBy(xpath="//span[@class='collapse-content collapse']")
	public WebElement hidePreviousVersionLink;

	@FindBy(xpath="//ul[@class='item-collapse item-list__revhistory']//li")
	public List<WebElement> previousVersionContainer;

	@FindBy(xpath="//a[@class='icon__cite']")
	public WebElement citeBtn;

	@FindBy(xpath="//div[@id='mheas-city-popup']//h3[@class='modal-title']")
	public WebElement citeModalTitle;
	
	@FindBy(xpath="//h4[@class='ris-h4']")
	public WebElement citeSubText;

	@FindBy(xpath="//div[@class='mla-style']")
//	@FindBy(xpath="//div[@class='mla-style']//span[@class='as-cite-title']")
	public WebElement citeMainTitle;

	@FindBy(xpath="//div[@id='mheas-city-popup']//button[@class='btn     btn-outline-primary']")
	public WebElement citeModalCloseBtn;

	@FindBy(xpath="//a[@class='btn btn-sm btn-primary save-search-icon']")
	public WebElement bookmarkBtn;

	@FindBy(xpath="//span[@class='sr-only']")
	public WebElement bookmarkedBtn;

	@FindBy(xpath="//a[@class='alert-toggle-status alert-enabled']")
	public WebElement removeBookmarkBtn;

	@FindBy(xpath="//a[normalize-space()='Manage bookmarks...']")
	public WebElement manageBookmarkBtn;

	@FindBy(xpath="//h2")
	public WebElement bookmarkTitle;

	@FindBy(xpath="//p[normalize-space()='Manage your bookmarks.']")
	public WebElement manageBookmarkText;

	@FindBy(xpath="//a[@id='highwire-personalization-dropdown-title']")
	public WebElement labelsBtn;

	@FindBy(xpath="//a[@class='highwire-modal-trigger']")
	public WebElement add_removeLabelBtn;

	@FindBy(xpath="//span[@id='ui-id-2']")
	public WebElement labelDialogueTitle;

	@FindBy(xpath="//a[@id='edit-create-tag-toggle']")
	public WebElement addLabelBtn;

	@FindBy(xpath="//input[@id='edit-create-tag-submit']")
	public WebElement addSaveLabelBtn;

	@FindBy(xpath="//input[@id='edit-submit']")
	public WebElement saveLabelBtn;

	@FindBy(xpath="//input[@id='edit-new-tag-label']")
	public WebElement labelInputbox;

	@FindBy(xpath="//a[normalize-space()='Manage labels...']")
	public WebElement manageLabelsBtn;

	@FindBy(xpath="//select[@id='edit-sort']")
	public WebElement labelSortDropdown;

	@FindBy(xpath="(//div[@class='highwire-personalization-manage-tag-panel__title'])[1]")
	public WebElement selectedLabelText;

	@FindBy(xpath="(//a[@class='highwire-modal-trigger text-danger'])[1]")
	public WebElement deleteLabelBtn;

	@FindBy(xpath="//input[@id='edit-submit--4']")
	public WebElement removeLabelBtn;

	@FindBy(xpath="//a[@title='Annotate']")
	public WebElement annotateBtn;
	
	@FindBy(xpath="//span[@id='ui-id-2']")
	public WebElement annotateModalTitle;

	@FindBy(xpath="//a[@class='icon__share']")
	public WebElement shareBtn;

	@FindBy(xpath="//div[@id='mheas-share-popup']//h3[@class='modal-title']")
	public WebElement shareModalTitle;
	
	@FindBy(xpath="//button[@class='ui-dialog-titlebar-close']")
	public WebElement annotateCloseBtn;

	@FindBy(xpath="//div[@class='modal-body ']//span[@class='a2a_s_link a2a_img_text hw-share-link-only']")
	public WebElement shareModalLink;

	@FindBy(xpath="//div[@id='a2a_copy_link']")
	public WebElement shareCopyLink;
	
	@FindBy(xpath="//div[@id='mheas-share-popup']//button[@class='btn     btn-outline-primary']")
	public WebElement shareModalCloseBtn;

	@FindBy(xpath="//span[normalize-space()='Download PDF']")
	public WebElement downloadpdfBtn;
	
	@FindBy(xpath="//a[@class='rsbtn_play']")
	public WebElement readSpeakerBtn;

	@FindBy(xpath="//a[@class='focus-link']")
	public WebElement focusViewBtn;
	
	@FindBy(xpath="//div[@class='action_tools']")
	public WebElement actionToolsContainer;
	
	@FindBy(xpath="//a[@class='focus-link']")
	public WebElement exitFocusViewBtn;
	
	@FindBy(xpath="//h1")
	public WebElement focusViewTitle;
	
	@FindBy(xpath="//div[@class='toc-open-click']")
	public WebElement OpenTOCBtn;
	
	@FindBy(xpath="//div[@class='toc-close-click']")
	public WebElement hideTOCBtn;
	
	@FindBy(xpath="//ul[@class=' item-list__highwire_content_nav']//a")
	public List<WebElement> tocContainer;
	
	@FindBy(xpath="(//ul[@class=' item-list__highwire_content_nav']//a)[1]")
	public WebElement tocFirstElement;
	
	@FindBy(xpath="(//h2[@class='title'])[2]")
	public WebElement tocFirstElementTitle;
	
	@FindBy(xpath="//p[normalize-space()='Organize your content by creating and applying one or more labels to an item.']")
	public WebElement manageLabelIntro;
	
	@FindBy(xpath="//div[@class='']//button[@class='highwire-modal-trigger btn btn-primary btn-sm']")
	public WebElement manageLabelAddBtn;
	
	@FindBy(xpath="(//a[@class='markup-item-link'])[1]")
	public WebElement openNewTabBtn;
	
	@FindBy(xpath="(//div[@class='title'])[1]")
	public WebElement elementTitle;
	
	@FindBy(xpath="(//a[@class='a2a_button_copy_link markup-item-link'])[1]")
	public WebElement shareElementBtn;
	
	@FindBy(xpath="//input[@id='a2a_copy_link_text']")
	public WebElement shareElementCopyLink;
	
//	@FindBy(xpath="(//a[@title='Show More'])[1]")
	@FindBy(xpath="(//div[@class='show-more'])[1]")
	public WebElement raShowMoreBtn;
	
	@FindBy(xpath="(//div[@class='show-more'])[2]")
	public WebElement rnShowMoreBtn;
	
	@FindBy(xpath="(//div[@class='show-more'])[3]")
	public WebElement rvShowMoreBtn;
	
	@FindBy(xpath="(//div[@class='show-more'])[4]")
	public WebElement rbcShowMoreBtn;
	
	@FindBy(xpath="//div[@class='sidebar sidebar-article']//h5[normalize-space()='Related Articles']")
	public WebElement relatedNewsText;
	
	@FindBy(xpath="//div[@class='sidebar sidebar-article']//h5[normalize-space()='Related Videos']")
	public WebElement relatedVideosText;
	
	@FindBy(xpath="//div[@class='sidebar sidebar-article']//h5[normalize-space()='Related Book Chapters']")
	public WebElement relatedBookChaptersText;
	
	@FindBy(xpath="//div[@class='sidebar sidebar-article']//h5[normalize-space()='Topics']")
	public WebElement topicsText;
	
	@FindBy(xpath="//a[@id='edit-group-figures-tables-label']")
	public WebElement figuresTableslabelBtn;
	
	@FindBy(xpath="//h2[@class='section-title']")
	public WebElement figuresText;
	
	@FindBy(xpath="//a[@id='edit-group-primary-literature-label']")
	public WebElement primaryLiteratureLabel;
	
	@FindBy(xpath="//ol[@class='ref-list table no-labels']")
	public WebElement primaryLiteratureData;
	
	@FindBy(xpath="//a[@id='edit-group-self-test-label']")
	public WebElement selfTestBtn;
	
	@FindBy(xpath="//div[@class='sect1 mhe-item-collapse']//div[@class='title']")
	public WebElement testYourUnderstandingText;

	//	WebElement Functions
	
	public String get_test_your_understanding_text() {
		String text = testYourUnderstandingText.getText();
		return text;
	}
	
	public void click_self_test_button() {
		selfTestBtn.click();
		log.info("Self test button clicked");
	}
	
	public void click_primary_literature_label() {
		primaryLiteratureLabel.click();
		log.info("Primary literature label clicked");
	}
	
	public void click_figures_tables_labels_button() {
		figuresTableslabelBtn.click();
		log.info("Figures and Tables labels button clicked");
	}
	
	public void click_related_book_chapters_show_more_button() {
		rbcShowMoreBtn.click();
		log.info("Related Book chapters show more button clicked");
	}
	
	public void click_related_videos_show_more_button() {
		rvShowMoreBtn.click();
		log.info("Related Videos show more button clicked");
	}
	
	public void click_related_news_show_more_button() {
		rnShowMoreBtn.click();
		log.info("Related News showmore button clicked");			
	}
	
	public void click_related_article_show_more_button() {
		raShowMoreBtn.click();
		log.info("Related article show more button clicked");
	}
	
	public void click_share_element_copy_link() {
		shareElementCopyLink.click();
		log.info("Share element copy link clicked");
	}
	
	public void click_share_element_button() {
		shareElementBtn.click();
		log.info("Share element button clicked");
		}
	
	public String get_element_title() {
		String title = elementTitle.getText();
		return title;
	}
	
	public void click_open_new_tab_link() {
		openNewTabBtn.click();
		log.info("Open in New Tab link clicked");
	}
	
	public void click_hide_toc_button() {
		hideTOCBtn.click();
		log.info("Hide TOC button clicked");
	}
	
	public String get_toc_first_element_title() {
		String text = tocFirstElementTitle.getText();
		return text;
	}
	
	public String get_toc_first_element_text() {
		String text = tocFirstElement.getText();
		return text;
	}
	
	public void click_toc_first_element() {
		tocFirstElement.click();
		log.info("TOC first element clicked");
	}
	
	public void click_table_of_content_button() {
		OpenTOCBtn.click();
		log.info("Table of content button clicked");
	}
	
	public String get_focus_view_title() {
		String text = focusViewTitle.getText();
		return text;
	}
	
	public void click_exit_focus_view_button() {
		exitFocusViewBtn.click();
		log.info("Exit focus view button clicked");
	}	
	
	public void click_share_modal_close_button() {
		shareModalCloseBtn.click();
		log.info("Close button in Share modal clicked");
	}
	
	public void click_annotate_close_button() {
		annotateCloseBtn.click();
		log.info("Annotate close button clicked");
	}
	
	public String get_annotate_title_text() {
		String text = annotateModalTitle.getText();
		return text;
	}

	public void click_share_modal_link() {
		shareModalLink.click();
		log.info("Share modal Link clicked");
	}

	public void click_remove_label_button() {
		removeLabelBtn.click();
		log.info("Remove label button clicked");
	}

	public void click_delete_label_button() {
		deleteLabelBtn.click();
		log.info("Delete label button clicked ");
	}

	public String get_selected_label_text() {
		String text = selectedLabelText.getText();
		return text;
	}

	public void click_manage_labels_button() {
		manageLabelsBtn.click();
		log.info("Manage Labels button clicked");
	}

	public void click_add_save_label_button() {
		addSaveLabelBtn.click();
		log.info("Add save label button clicked");
	}

	public void enter_label_name(String labelname) {
		labelInputbox.sendKeys(labelname);
		log.info("Label name entered successfully");
	}

	public void click_add_remove_label_button() {
		add_removeLabelBtn.click();
		log.info("Add/Remove Label button clicked");
	}

	public void click_save_label_button() {
		saveLabelBtn.click();
		log.info("Save button clicked");
	}

	public void click_add_label_button() {
		addLabelBtn.click();
		log.info("Add label button clicked");
	}

	public String get_label_dialogue_title_text() {
		String text = labelDialogueTitle.getText();
		return text;
	}

	public void click_remove_bookmark_button() {
		removeBookmarkBtn.click();
		log.info("Remove bookmark button clicked");
	}

	public String get_bookmark_page_title() {
		String title = bookmarkTitle.getText();
		return title;
	}

	public void click_bookmarked_button() {
		bookmarkedBtn.click();
		log.info("Bookmarked button clicked");
	}

	public void click_manage_bookmark_button() {
		manageBookmarkBtn.click();
		log.info("Manage bookmark button clicked");
	}

	public String get_manage_bookmark_text() {
		String text = manageBookmarkText.getText();
		return text ;
	}

	public String get_cite_main_title() {
		String text = citeMainTitle.getText();
		return text;
	}

	public void click_focus_view_button() {
		focusViewBtn.click();
		log.info("Focus view button clicked");
	}

	public void click_download_pdf_button() {
		downloadpdfBtn.click();
		log.info("Download PDF button clicked");
	}

	public String get_share_modal_title() {
		String text = shareModalTitle.getText();
		return text;
	}

	public void click_share_button() {
		shareBtn.click();
		log.info("Share button clicked");
	}

	public void click_annotate_button() {
		annotateBtn.click();
		log.info("Annotate button clicked");
	}

	public void click_labels_button() {
		labelsBtn.click();
		log.info("Labels button clicked");
	}

	public void click_bookmark_button() {
		bookmarkBtn.click();
		log.info("Bookmark button clicked");
	}

	public void click_cite_modal_close_button() {
		citeModalCloseBtn.click();
		log.info("Cite Modal Close button clicked");
	}

	public void click_cite_button() {
		citeBtn.click();
		log.info("Cite button clicked");
	}

	public int get_previous_version_count() {
		int n = previousVersionContainer.size();
		return n;
	}

	public void click_hide_previous_version_link() {
		hidePreviousVersionLink.click();
		log.info("Hide previous versions link clicked");
	}

	public void click_show_previous_version_link() {
		showPreviousVersionLink.click();
		log.info("Show previous version link clicked");
	}

	public String get_article_doi_link() {
		String text = articleDOI.getText();
		return text;
	}

	public String get_last_review_date() {
		String text = lastReviewDate.getText();
		return text;
	}

	public String get_author_name() {
		String name = authorName.getText();
		return name;
	}

	public String get_artcile_title_text() {
		String text = articleTitle.getText();
		return text;
	}


}
