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


public class TestsSecond{

    public WebDriver driver = new ChromeDriver();
    public MainPage mainPage = new MainPage(driver);
    public NewPastePage newPastePage = new NewPastePage(driver);

    @Before
    public void setUp(){driver.get(Variables.MAIN_PAGE_URL);}

    @Test
    public void createAndCheckNewPaste(){
        mainPage.createPasteAndCheck(Variables.CODE_TO_PAST, Variables.PASTE_TITLE_SECOND, Variables.TIME, Variables.EXPIRATION_TYPE);
        mainPage.clickCreateNewPasteButton();

        String browserTitle = driver.getTitle();
        String expectSyntax = newPastePage.readExpirationType();
        String expectTitle = newPastePage.readNewPasteTitle();
        String expectCodeToPast = newPastePage.readTextField();

        Assert.assertEquals("Unexpected syntax", Variables.EXPIRATION_TYPE,expectSyntax);
        Assert.assertEquals("Unexpected text", Variables.CODE_TO_PAST, expectCodeToPast);
        Assert.assertTrue("Unexpected title",browserTitle.contains(expectTitle));
    }
    
    @After
    public void end(){
        driver.quit();
    }
}
