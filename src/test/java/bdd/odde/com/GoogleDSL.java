package bdd.odde.com;

import org.openqa.selenium.WebDriver;

public class GoogleDSL {

    private SearchPage searchPage;

    public GoogleDSL() {
        this.searchPage = new SearchPage();
    }

    public void goHome() {
        searchPage.load();
    }

    public void search(String keyword) {
        searchPage.inputAndSubmit(keyword);
    }

    public boolean hasFound(String content) {
        return searchPage.contains(content);
    }

    public String getTitle() {
        return searchPage.getTitle();
    }

    public void close() {
        searchPage.close();
    }

}