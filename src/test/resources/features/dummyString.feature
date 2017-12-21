Feature: Test Dummy String Feature

  Scenario: Happy flow
    Given The system is in a known state
    When I have a string with the value "Monday"
    Then the length should be 6


  Scenario Outline: Happy flow Outline
    Given The system is in a known state
    When I have a string with the value "<value>"
    Then the length should be <length_of_value>

    Examples:
    | value       | length_of_value |
    | monday      | 6               |
    | Saturday    | 8               |
#    | null        | null            |



