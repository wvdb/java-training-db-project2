Feature: process Employee XML File

  Scenario: Happy flow
    Given there is a valid XML file
    When the file has been processed
    Then employees should contain 2 entries
    And employee should be correct