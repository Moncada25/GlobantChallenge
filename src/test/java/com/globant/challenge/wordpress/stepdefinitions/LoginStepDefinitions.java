package com.globant.challenge.wordpress.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

  @Given("the user open Wordpress page")
  public void theUserOpenWordpressPage() {

  }

  @When("he login using a password {string}")
  public void heSheLoginUsingAPassword(String string) {

  }

  @Then("should see the page {string}")
  public void shouldSeeTheHome(String title) {

  }

  @Then("should see a error message")
  public void shouldSeeTheMessageError() {

  }
}
