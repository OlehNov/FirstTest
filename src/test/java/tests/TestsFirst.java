package tests;

import base.Variables;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.NewPastePage;

public class TestsFirst{

    public WebDriver driver = new ChromeDriver();
    public MainPage mainPage = new MainPage(driver);
    public NewPastePage newPastePage = new NewPastePage(driver);

    @Before
    public void setUp(){
        driver.get(Variables.MAIN_PAGE_URL);
    }

    @Test
    public void createNewPaste(){
        mainPage.createPaste(Variables.NEW_PASTE, Variables.PASTE_TITLE_FIRST, Variables.TIME);
        mainPage.clickCreateNewPasteButton();
        String actualResult = newPastePage.readNewPasteTitle();
        Assert.assertEquals("Unexpected result:", Variables.PASTE_TITLE_FIRST, actualResult);
    }

    @After
    public void end(){
        driver.quit();
    }
}
