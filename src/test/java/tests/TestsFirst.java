package tests;

import base.Base;
import base.Variables;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestsFirst extends Variables {

    String newPaste = "Hello from WebDrive";
    String pasteTitleName = "helloweb";

    @Before
    public void setUp(){
        driver.get(Base.mainPageURL);
    }

    @Test
    public void createNewPaste(){
        mainPage.createPasteTenMinutes(newPaste,pasteTitleName);
        String actualResult = newPastePage.readNewPasteTitle();
        Assert.assertEquals("Unexpected result:", pasteTitleName, actualResult);
    }

    @After
    public void end(){
        driver.quit();
    }
}
