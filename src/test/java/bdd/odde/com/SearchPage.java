package bdd.odde.com;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class SearchPage {
    private WebDriver _driver;
    private Wait<WebDriver> _wait;

    private By queryInput = By.name("q");
    private By searchButton = By.name("btnK");

    public SearchPage() {
        initDriver();

        _wait = new FluentWait<WebDriver>(_driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

   }

    public void inputAndSubmit(String keyword) {
        try {
            WebElement q = _wait.until(driver -> driver.findElement(queryInput));
            q.sendKeys(keyword);

            WebElement btnK = _wait.until(driver -> driver.findElement(this.searchButton));
            btnK.submit();
        } catch (NullPointerException exp) {
            System.console().printf("Error: %s", exp.getMessage());
        }

    }

    private WebDriver initDriver() {
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