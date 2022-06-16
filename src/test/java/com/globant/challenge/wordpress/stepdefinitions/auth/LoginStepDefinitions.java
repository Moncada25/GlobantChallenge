package com.globant.challenge.wordpress.stepdefinitions.auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;

import com.globant.challenge.wordpress.exceptions.CommonsException;
import com.globant.challenge.wordpress.questions.TheProfile;
import com.globant.challenge.wordpress.questions.TheError;
import com.globant.challenge.wordpress.tasks.Login;

import static org.hamcrest.Matchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static com.globant.challenge.wordpress.utilities.ReadFiles.getUser;
import static com.globant.challenge.wordpress.utilities.DriverFactory.getDriver;

import static com.globant.challenge.wordpress.utilities.contants.Copies.LOGIN_FAILED;
import static com.globant.challenge.wordpress.utilities.contants.GeneralConstants.ACTOR;
import static com.globant.challenge.wordpress.utilities.contants.ExceptionsMessage.LOGIN_SUCCESS;
import static com.globant.challenge.wordpress.utilities.contants.ExceptionsMessage.LOGIN_FAIL;

public class LoginStepDefinitions {

  @Given("the user open Wordpress page")
  public void theUserOpenWordpressPage() {
    setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(getDriver())));
    theActorCalled(ACTOR);
  }

  @When("he login using a credentials {string}")
  public void heLoginUsingACredentials(String user) {
    theActorInTheSpotlight().attemptsTo(
        Login.wordpress(getUser(user))
    );
  }

  @Then("should see his profile")
  public void shouldSeeHisProfile() {
    theActorInTheSpotlight().should(
        seeThat(TheProfile.isDisplayed()
        ).orComplainWith(CommonsException.class, LOGIN_FAIL)
    );
  }

  @Then("should see an error message")
  public void shouldSeeAnErrorMessage() {
    theActorInTheSpotlight().should(
        seeThat(TheError.message(), is(LOGIN_FAILED)
        ).orComplainWith(CommonsException.class, LOGIN_SUCCESS)
    );
  }
}
