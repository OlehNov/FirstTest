package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class TestsFirst {
    private WebDriver driver;
    private MainPage mainPage;
    private static final String EXPECTED_RESULT = "NOTE:";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get(mainPage.mainPageURL);
    }

    @Test
    public void createNewPaste(){
        String newPaste = "Hello from WebDrive";
        String pasteTitleName = "helloweb";

        mainPage.createPaste(newPaste,pasteTitleName,driver);

        String actualResult = mainPage.readResultText();
        Assert.assertEquals("Unexpected result:", EXPECTED_RESULT, actualResult);
    }

    @After
    public void end(){
        driver.quit();
    }
}
