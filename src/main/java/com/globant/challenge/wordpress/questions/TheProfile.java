package com.globant.challenge.wordpress.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;

import com.globant.challenge.wordpress.models.User;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static com.globant.challenge.wordpress.userinterfaces.HomeElements.BTN_ACCOUNT_SETTINGS;
import static com.globant.challenge.wordpress.userinterfaces.HomeElements.BTN_MY_PROFILE;
import static com.globant.challenge.wordpress.userinterfaces.HomeElements.TXT_PROFILE_EMAIL;
import static com.globant.challenge.wordpress.utilities.contants.SessionVariables.USER_LOGGED;

public class TheProfile implements Question<Boolean> {

  public static TheProfile isDisplayed(){
    return new TheProfile();
  }

  @Subject("verify login success on the home page")
  @Override
  public Boolean answeredBy(Actor actor) {

    User userLogged = Serenity.sessionVariableCalled(USER_LOGGED);

    actor.attemptsTo(
        WaitUntil.the(BTN_MY_PROFILE, isVisible()).forNoMoreThan(2).seconds(),
        Click.on(BTN_MY_PROFILE),
        Click.on(BTN_MY_PROFILE)
    );

    actor.attemptsTo(
        WaitUntil.the(BTN_ACCOUNT_SETTINGS, isVisible()).forNoMoreThan(2).seconds(),
        Click.on(BTN_ACCOUNT_SETTINGS)
    );

    return TXT_PROFILE_EMAIL.resolveFor(actor).getAttribute("value").equals(userLogged.getEmail());
  }
}
