Feature: Testing


  @testing
  Scenario: Testing the URL open
    Given I open the daraz URL
    When  I assert the title of the page
    And   I click on login
