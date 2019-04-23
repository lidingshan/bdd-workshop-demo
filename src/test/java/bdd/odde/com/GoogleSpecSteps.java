package bdd.odde.com;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GoogleSpecSteps {
    private GoogleDSL googleDSL;

    @Before
    public void setUp() {
        this.googleDSL = new GoogleDSL();
    }

    @After
    public void tearDown() {
        googleDSL.close();
    }

    @When("^navigate to google home$")
    public void navigate_to_google_home() throws Throwable {
        googleDSL.goHome();
    }

    @Then("^the page title should be \"(.*?)\"$")
    public void the_page_title_should_be(String expected) throws Throwable {
        Assert.assertEquals(expected, googleDSL.getTitle());
    }

    @When("^search the keyword of \"(.*?)\"$")
    public void search_the_keyword_of(String keyword) throws Throwable {
        googleDSL.search(keyword);
    }

    @Then("^the result should include \"(.*?)\"$")
    public void the_result_should_include(String expected) throws Throwable {
        Assert.assertTrue(googleDSL.hasFound(expected));
    }

}
