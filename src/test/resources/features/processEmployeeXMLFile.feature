Feature: process Employee XML File

  Scenario: Happy flow
    Given there is an XML File Processor
    When a correct file has been processed
    Then employees should contain 2 entries
    And age should be correct
    And name should be correct
    And hire-date should be correct
    And ssn should be correct

  Scenario: Sad flow
    Given there is an XML File Processor
    When a not existing file has been processed
    Then a correct exception should have been thrown

