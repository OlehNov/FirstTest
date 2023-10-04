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
    @FindBy(xpath = "//li[text()=\"10 Minutes\"]")
    public WebElement pasteExpirationTenMinutesOption;
    @FindBy(css=".form-group.field-postform-format .select2-selection__arrow")
    private WebElement highlighting;
    @FindBy(xpath = "(//li[contains(text(), 'Bash')])[1]")
    public WebElement bashHighlighting;

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

    public void tenMinutesOptionClick(WebElement pasteExpiration){
       wait.until(ExpectedConditions.elementToBeClickable(pasteExpiration)).click();
        System.out.println("Paste expiration option was clicked success");
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

    public void bashHighlightingClick(WebElement syntax){
        wait.until(ExpectedConditions.elementToBeClickable(syntax)).click();
        System.out.println("Syntax option was clicked success");
    }

    //
    public void createPasteTenMinutes(String newPaste, String pasteTitleName, WebElement pasteExpiration){
        MainPage mainPage = new MainPage(driver);
        mainPage.enterNewPasteText(newPaste);
        mainPage.pasteExpirationClick();
        mainPage.tenMinutesOptionClick(pasteExpiration);
        mainPage.enterTitleNameText(pasteTitleName);
    }

    public void createPasteBashTenMinutes(String newPaste, String pasteTitleName,WebElement pasteExpiration,
                                          WebElement syntax){
        MainPage mainPage = new MainPage(driver);
        mainPage.syntaxHighlightingClick();
        mainPage.bashHighlightingClick(syntax);
        createPasteTenMinutes(newPaste,pasteTitleName,pasteExpiration);
    }
}
