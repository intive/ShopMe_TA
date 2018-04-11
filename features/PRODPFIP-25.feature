Feature: PRODPFIP-25 Alternative flow of searching for a service

  Scenario Outline: Display no offer message
    Given that there are no services added
    And I add services
      | odśnieżanie        |
      | programowanie Java |
    And I navigate to the main page
    When I enter a searching phrase "<phrase_that_does_not_exist>" into the search field
    And I click the search button
    Then I can see no results message "Niestety nie znaleziono ofert spełniających Twoje kryteria"

    Examples:
      | phrase_that_does_not_exist |
      | sprzątanie                 |
      | programowanie Python       |

  Scenario Outline: Display no offer message after search again
    Given I navigate to the main page
    And I enter a searching phrase "odśnieżanie" into the search field
    And I click the search button
    When I enter a searching phrase "<phrase_that_does_not_exist>" into the search field
    And I click the search button
    Then I can see no results message "Niestety nie znaleziono ofert spełniających Twoje kryteria"

    Examples:
      | phrase_that_does_not_exist |
      | sprzątanie                 |
      | programowanie Python       |
