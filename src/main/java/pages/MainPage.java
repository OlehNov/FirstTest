package pages;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends Base {

    // ***Locators and selectors***

    //CSS
    @FindBy(css = ".form-group.field-postform-text.required #postform-text")
    private WebElement newPasteField;
    @FindBy(css = ".post-form__left .field-postform-expiration .select2" )
    private WebElement pasteExpirationDropdownListButton;
    @FindBy(css = ".post-form__left .field-postform-name #postform-name")
    private WebElement pasteNameField;
    @FindBy(css=".form-group.form-btn-container .btn")
    private WebElement createNewPasteButton;
    @FindBy(css = " .select2-results__options :nth-child(3)")
    private WebElement pasteExpirationTenMinutesOption;
    @FindBy(css=".form-group.field-postform-format .select2-selection__arrow")
    private WebElement highlighting;
    @FindBy(css = ".select2-results__options.select2-results__options--nested > :first-child")
    private WebElement bashHighlighting;

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    //Actions
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public void enterNewPasteText(String pasteTitleName){
        wait.until(ExpectedConditions.elementToBeClickable(newPasteField)).sendKeys(pasteTitleName);
        System.out.println("Text entered into the New Paste");
    }

    public void pasteExpirationClick(){
        wait.until(ExpectedConditions.elementToBeClickable(pasteExpirationDropdownListButton)).click();
        System.out.println("Button was clicked success");
    }

    public void tenMinutesOptionClick(){
       wait.until(ExpectedConditions.elementToBeClickable(pasteExpirationTenMinutesOption)).click();
        System.out.println("Ten minutes option was clicked success");
    }

    public void enterTitleNameText(String titleName){
        wait.until(ExpectedConditions.elementToBeClickable(pasteNameField)).sendKeys(titleName);
        System.out.println("Text entered into the Title name");
    }

    public void clickCreateNewPasteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(createNewPasteButton)).click();
        System.out.println("Button was clicked success");
    }

    public void syntaxHighlightingClick(){
        wait.until(ExpectedConditions.elementToBeClickable(highlighting)).click();
        System.out.println("Highlighting button was clicked success");
    }

    public void bashHighlightingClick(){
        wait.until(ExpectedConditions.elementToBeClickable(bashHighlighting)).click();
        System.out.println("Bash option was clicked success");
    }



    //
    public void createPasteTenMinutes(String newPaste, String pasteTitleName){
        MainPage mainPage = new MainPage(driver);
        mainPage.enterNewPasteText(newPaste);
        mainPage.pasteExpirationClick();
        mainPage.tenMinutesOptionClick();
        mainPage.enterTitleNameText(pasteTitleName);
        mainPage.clickCreateNewPasteButton();
    }

    public void createPasteBashTenMinutes(String newPaste, String pasteTitleName){
        MainPage mainPage = new MainPage(driver);
        mainPage.enterNewPasteText(newPaste);
        mainPage.syntaxHighlightingClick();
        mainPage.bashHighlightingClick();
        mainPage.pasteExpirationClick();
        mainPage.tenMinutesOptionClick();
        mainPage.enterTitleNameText(pasteTitleName);
        mainPage.clickCreateNewPasteButton();
    }
}
