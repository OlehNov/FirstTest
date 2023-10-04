package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.NewPastePage;

public class Variables {

    public final WebDriver driver = new ChromeDriver();
    public final MainPage mainPage = new MainPage(driver);
    public final NewPastePage newPastePage = new NewPastePage(driver);
}
