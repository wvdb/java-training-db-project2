Feature: OCA-Certification

  Scenario: Happy flow
    Given I participate
    When I succeed
    Then I should be certified and have a score of at least 65

