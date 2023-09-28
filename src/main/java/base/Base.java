package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    public String mainPageURL = "https://pastebin.com/";

    public WebDriver driver;
    public Base(WebDriver driver){
        this.driver = driver;
    }
}
