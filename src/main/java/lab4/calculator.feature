Feature: Calculator

  Scenario: Addition
    Given the first number is 5
    And the second number is 3
    When the user presses plus
    Then the result should be 8

  Scenario: Subtraction
    Given the first number is 5
    And the second number is 3
    When the user presses minus
    Then the result should be 2

  Scenario: Multiplication
    Given the first number is 5
    And the second number is 3
    When the user presses multiply
    Then the result should be 15

  Scenario: Division
    Given the first number is 6
    And the second number is 2
    When the user presses divide
    Then the result should be 3

  Scenario: Division by zero
    Given the first number is 6
    And the second number is 0
    When the user presses divide
    Then an ArithmeticException should be thrown

  Scenario: Plus button click
    Given the calculator is initialized
    When the user clicks the plus button
    Then the controller's processInput method should be called with '+'

  Scenario: Minus button click
    Given the calculator is initialized
    When the user clicks the minus button
    Then the controller's processInput method should be called with '-'

  Scenario: Multiply button click
    Given the calculator is initialized
    When the user clicks the multiply button
    Then the controller's processInput method should be called with '*'

  Scenario: Divide button click
    Given the calculator is initialized
    When the user clicks the divide button
    Then the controller's processInput method should be called with '/'

  Scenario: Divide by zero error
    Given the calculator is initialized
    When the user presses divide
    Then the controller's error method should be called with an error message