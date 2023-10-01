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
    @FindBy(css = ".top-buttons .left > :first-child")
    private WebElement pasteExpirationType;
    @FindBy(css = ".info-bar .info-top>h1")
    private WebElement pasteTitle;
    @FindBy(css=".highlighted-code .source>ol")
    private WebElement pasteTextField;


    public NewPastePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public String readNewPasteTitle(){
        return wait.until(ExpectedConditions.elementToBeClickable(pasteTitle)).getText();
    }

    public String readExpirationType(){
        return wait.until(ExpectedConditions.elementToBeClickable(pasteExpirationType)).getText();
    }

    public String readTextField(){
        return wait.until(ExpectedConditions.elementToBeClickable(pasteTextField)).getText();
    }

    public void fullTextCheck(String pasteTitle, String pasteExpirationType, String pasteTextField){
        NewPastePage check = new NewPastePage(driver);
        boolean titleCorrect = readNewPasteTitle().equals(pasteTitle);
        boolean expirationTypeCorrect = readExpirationType().equals(pasteExpirationType);
        boolean textFieldCorrect =  readTextField().equals(pasteTextField);
        if (titleCorrect && expirationTypeCorrect && textFieldCorrect){
            System.out.println("All fields are correct");
        } else {
            if (!titleCorrect){
                System.out.println("WARNING:Title is incorrect");
            }
            if (!expirationTypeCorrect){
                System.out.println("WARNING:ExpirationType is incorrect");
            }
            if(!textFieldCorrect){
                System.out.println("WARNING:TextField is incorrect");
            }
        }

    }
}
