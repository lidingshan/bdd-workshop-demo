package bdd.odde.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleDSL {

    private WebDriver _driver;

    public GoogleDSL() {
    }

    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/lidingshan/lib/selenium/chromedriver");
        _driver = new ChromeDriver();
    }

    public void goHome() {
        this._driver.get("https://www.google.com");
    }

    public void search(String keyword) {
        _driver.findElement(By.name("q")).sendKeys(keyword);
        _driver.findElement(By.name("btnK")).submit();
    }

    public boolean hasFound(String content) {
        return _driver.getPageSource().contains(content);
    }

    public String getTitle() {
        return _driver.getTitle();
    }

    public void close() {
        _driver.quit();
    }
}