package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    @FindBy(css=".form-group.field-postform-format .select2-selection__arrow")
    private WebElement highlighting;
    private final static String TIME_PERIOD = "//li[text()='%s']";
    private final static String SYNTAX = "//li[text()='%s']";

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Actions
    public void enterNewPasteText(String pasteTitleName){
        wait.until(ExpectedConditions.elementToBeClickable(newPasteField)).sendKeys(pasteTitleName);
        System.out.println("Text entered into the New Paste");
    }

    public void pasteExpirationClick(){
        wait.until(ExpectedConditions.elementToBeClickable(pasteExpirationDropdownListButton)).click();
        System.out.println("Button was clicked success");
    }

    public void enterTitleNameText(String titleName){
        wait.until(ExpectedConditions.elementToBeClickable(pasteNameField)).sendKeys(titleName);
        System.out.println("Text entered into the Title name");
    }

    public void clickCreateNewPasteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(createNewPasteButton)).click();
        System.out.println("Button was clicked success");
    }

    public void syntaxDropDownClick(){
        wait.until(ExpectedConditions.elementToBeClickable(highlighting)).click();
        System.out.println("Highlighting button was clicked success");
    }


    //Time slots in drop_down list
    public void xpath(String locator, String value){
        String xpath = String.format(locator, value);
        WebElement seriesElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        seriesElement.click();
    }

    public void createPaste(String newPaste, String pasteTitleName, String time){
        enterNewPasteText(newPaste);
        pasteExpirationClick();
        xpath(TIME_PERIOD, time);
        enterTitleNameText(pasteTitleName);
    }

    public void createPasteAndCheck(String newPaste, String pasteTitleName, String time, String highlighting){
        syntaxDropDownClick();
        xpath(SYNTAX, highlighting);
        createPaste(newPaste,pasteTitleName,time);
  }
}
