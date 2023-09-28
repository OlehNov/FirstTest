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
    String url;
    public MainPage(WebDriver driver){
        super(driver);
        this.url = mainPageURL;
        PageFactory.initElements(driver, this);
    }

    // ***Locators and selectors***
    private final String optionalPasteSettingsPanel = ".post-form__left >:nth-child";

    //CSS
    @FindBy(css = ".form-group.field-postform-text.required #postform-text")
    private WebElement newPasteField;
    @FindBy(css = optionalPasteSettingsPanel + "(4) .select2" )
    private WebElement pasteExpirationDropdownListButton;
    @FindBy(css = optionalPasteSettingsPanel + "(9) .form-control")
    private WebElement pasteNameField;
    @FindBy(css=".form-group.form-btn-container .btn")
    private WebElement createNewPasteButton;
    @FindBy(css = ".select2-results__options :nth-child(3)")
    private WebElement pasteExpirationTenMinutesOption;
    @FindBy(css=".post-view.js-post-view .notice.-success.-post-view >:nth-child(1)")
    private WebElement successNOTE;


    //Actions
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public String readResultText(){
        return wait.until(ExpectedConditions.elementToBeClickable(successNOTE)).getText();
    }

    public void createPaste(String newPaste, String pasteTitleName, WebDriver driver){
        MainPage mainPage = new MainPage(driver);
        mainPage.enterNewPasteText(newPaste);
        mainPage.pasteExpirationClick();
        mainPage.tenMinutesOptionClick();
        mainPage.enterTitleNameText(pasteTitleName);
        mainPage.clickCreateNewPasteButton();
    }
}
