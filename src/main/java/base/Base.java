package base;

import org.openqa.selenium.WebDriver;


public class Base {
    public static String mainPageURL = "https://pastebin.com/";

    public WebDriver driver;
    public Base(WebDriver driver){
        this.driver = driver;
    }

}
