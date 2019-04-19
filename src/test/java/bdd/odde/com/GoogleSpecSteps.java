package bdd.odde.com;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSpecSteps {
    private final GoogleDSL googleDSL = new GoogleDSL();
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = googleDSL.initDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @When("^navigate to google home$")
    public void navigate_to_google_home() throws Throwable {
        googleDSL.goHome();
    }

    @Then("^the page title should be \"(.*?)\"$")
    public void the_page_title_should_be(String expected) throws Throwable {
        Assert.assertEquals(expected, driver.getTitle());
    }

    @When("^search the keyword of \"(.*?)\"$")
    public void search_the_keyword_of(String keyword) throws Throwable {
        driver.findElement(By.name("q")).sendKeys(keyword);
        driver.findElement(By.name("btnK")).submit();
    }

    @Then("^the result should include \"(.*?)\"$")
    public void the_result_should_include(String expected) throws Throwable {
        Assert.assertTrue(driver.getPageSource().contains(expected));
    }

}
