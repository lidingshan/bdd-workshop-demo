package bdd.odde.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchPage {
    private WebDriver _driver;

    public SearchPage() {
        initDriver();
    }

    public void inputAndSubmit(String keyword) {
        _driver.findElement(By.name("q")).sendKeys(keyword);
        _driver.findElement(By.name("btnK")).submit();
    }

    public WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/lidingshan/lib/selenium/chromedriver");
        this._driver = new ChromeDriver();
        return this._driver;
    }

    public void load() {
        _driver.get("https://www.google.com");
    }

    public String getTitle() {
        return _driver.getTitle();
    }

    public boolean contains(String content) {
        return _driver.getPageSource().contains(content);
    }

    public void close() {
        _driver.quit();
    }
}