Feature: Google search

    Scenario: Google home
        When navigate to google home
        Then the page title should be "Google"

    Scenario: Search keyword
        Given navigate to google home
        When search the keyword of "gumtree"
        Then the result should include "Gumtree"