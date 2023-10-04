package tests;

import base.Base;
import base.Variables;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;


public class TestsSecond extends Variables {

    String codeToPast = """
            git config --global user.name  "New Sheriff in Town"
            git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
            git push origin master --force""";
    String pasteTitleName = "how to gain dominance among developers";
    String expirationType = "Bash";

    @Before
    public void setUp(){
        driver.get(Base.mainPageURL);
    }
    @Test

    public void creatAndCheckNewPaste(){
        MainPage mainPage = new MainPage(driver);
        mainPage.createPasteBashTenMinutes(codeToPast,pasteTitleName);
        newPastePage.fullTextCheck(pasteTitleName, expirationType, codeToPast);
    }

    @After
    public void end(){
        driver.quit();
    }
}
