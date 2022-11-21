Feature: check calculator

  Background: on the main page
    Given Open site "http://localhost:8080/calculator"

  Scenario: input expression and look answer
    When all buttons are visible
    Then Close test

    #проверка на пустой ввод
  Scenario: empty input
    When all buttons are visible
    And empty expression is entered
    And press the button
    Then error message received

  #проверка на символы, не являющиеся цифрами
  Scenario: the characters entered are not numbers
    When all buttons are visible
    And characters is entered
    And press the button
    Then expression is wrong message

  #Вводим только одно слагаемое
  Scenario: only one term
    When all buttons are visible
    And term is entered
    And press the button
    Then expression is wrong message

  Scenario: only one term and action
    When all buttons are visible
    And term and action is entered
    And press the button
    Then expression is wrong message

  Scenario: correct answer is subtraction
    When all buttons are visible
    And "32.5", "-", "2.2" is entered
    And press the button
    Then response received

  Scenario: correct answer is addition
    When all buttons are visible
    And "5  ", "+    ", "2.3   " is entered
    And press the button
    Then response received

  Scenario: correct answer is divide
    When all buttons are visible
    And "5.5", " / ", " 2" is entered
    And press the button
    Then response received

  Scenario: correct answer is multiply
    When all buttons are visible
    And "0", "*    ", "0" is entered
    And press the button
    Then response received

  Scenario: correct answer is divide on null
    When all buttons are visible
    And "4", "/", "0" is entered
    And press the button
    Then response received