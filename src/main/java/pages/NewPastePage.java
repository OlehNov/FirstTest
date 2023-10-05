package pages;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NewPastePage extends Base {

    //CSS
    @FindBy(css = ".top-buttons .left>a[class^=\"btn -small h_800\"]")
    private WebElement pasteExpirationType;
    @FindBy(css = ".info-bar .info-top>h1")
    private WebElement pasteTitle;
    @FindBy(css=".highlighted-code .source>ol")
    private WebElement pasteTextField;

    public NewPastePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String readNewPasteTitle(){
        return wait.until(ExpectedConditions.elementToBeClickable(pasteTitle)).getText();
    }

    public String readExpirationType(){
        return wait.until(ExpectedConditions.elementToBeClickable(pasteExpirationType)).getText();
    }

    public String readTextField(){
        return wait.until(ExpectedConditions.elementToBeClickable(pasteTextField)).getText();
    }
}
