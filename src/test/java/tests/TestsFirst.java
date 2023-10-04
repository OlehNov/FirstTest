package tests;

import base.Base;
import base.Variables;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class TestsFirst extends Variables {
////
    String newPaste = "Hello from WebDrive";
    String pasteTitleName = "helloweb";
    WebElement pasteExpiration = mainPage.pasteExpirationTenMinutesOption;

    @Before
    public void setUp(){
        driver.get(Base.mainPageURL);
    }

    @Test
    public void createNewPaste(){
        mainPage.createPasteTenMinutes(newPaste,pasteTitleName,pasteExpiration);
        mainPage.clickCreateNewPasteButton();
        String actualResult = newPastePage.readNewPasteTitle();
        Assert.assertEquals("Unexpected result:", pasteTitleName, actualResult);
    }

    @After
    public void end(){
        driver.quit();
    }
}
