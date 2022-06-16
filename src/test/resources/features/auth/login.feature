#author: Santiago Moncada

Feature: Login page
  I, as a user,
  I want to login my profile
  to use the page features

  Background:
    Given the user open Wordpress page

  @LoginSuccess
  Scenario: Login success
    When he login using a password 'correct'
    Then should see the page 'My Home'

  @LoginFailed
  Scenario: Login failed
    When he login using a password 'incorrect'
    Then should see a error message