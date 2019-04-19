package bdd.odde.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleDSL {

    private WebDriver _driver;

    public GoogleDSL() {
    }

    public WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/lidingshan/lib/selenium/chromedriver");
        _driver = new ChromeDriver();
        return _driver;
    }

    public void goHome() {
        this._driver.get("https://www.google.com");
    }
}