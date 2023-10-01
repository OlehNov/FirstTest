package base;

import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.NewPastePage;

public class Base {
    public static String mainPageURL = "https://pastebin.com/";

    public MainPage mainPage;
    public NewPastePage newPastePage;

    public WebDriver driver;
    public Base(WebDriver driver){
        this.driver = driver;
    }

}
