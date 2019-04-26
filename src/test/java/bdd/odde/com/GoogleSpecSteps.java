package bdd.odde.com;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GoogleSpecSteps {
    private SearchPage searchPage;

    @Before
    public void setUp() {
        searchPage = new SearchPage();
    }

    @After
    public void tearDown() {
        searchPage.close();
    }

    @When("^navigate to google home$")
    public void navigate_to_google_home() throws Throwable {
        searchPage.load();
    }

    @Then("^the page title should be \"(.*?)\"$")
    public void the_page_title_should_be(String expected) throws Throwable {
        Assert.assertEquals(expected, searchPage.getTitle());
    }

    @When("^search the keyword of \"(.*?)\"$")
    public void search_the_keyword_of(String keyword) throws Throwable {
        searchPage.inputAndSubmit(keyword);
    }

    @Then("^the result should include \"(.*?)\"$")
    public void the_result_should_include(String expected) throws Throwable {
        Assert.assertTrue(searchPage.contains(expected));
    }

}
