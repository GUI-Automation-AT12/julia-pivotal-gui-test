Feature: Login for pivotal

  In order to login in pivotal

  Scenario: I am trying login with the valid credentials
    Given I am on the login page
    When  I set email and password
    Then  I should view the "dashboard" suffix in the URL

  Scenario: I am trying login with the wrong credentials
    Given I am on the login page
    When  I set email and password with fields empty
    Then  I should view the "signin" suffix in the URL