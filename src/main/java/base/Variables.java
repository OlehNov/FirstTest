package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.NewPastePage;

public class Variables {

    public static final WebDriver driver = new ChromeDriver();
    public static final MainPage mainPage = new MainPage(driver);
    public static final NewPastePage newPastePage = new NewPastePage(driver);
}
