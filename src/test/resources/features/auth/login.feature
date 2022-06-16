#author: Santiago Moncada

Feature: Login page
  I, as a user,
  I want to login my profile
  to use the page features

  Background:
    Given the user open Wordpress page

  @LoginSuccess
  Scenario: Login success
    When he login using a credentials 'correct'
    Then should see his profile

  @LoginFailed
  Scenario: Login failed
    When he login using a credentials 'incorrect'
    Then should see an error message