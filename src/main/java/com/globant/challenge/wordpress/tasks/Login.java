package com.globant.challenge.wordpress.tasks;

import lombok.AllArgsConstructor;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import com.globant.challenge.wordpress.models.User;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static com.globant.challenge.wordpress.userinterfaces.LoginElements.BTN_SUBMIT;
import static com.globant.challenge.wordpress.userinterfaces.LoginElements.TXT_PASSWORD;
import static com.globant.challenge.wordpress.userinterfaces.LoginElements.TXT_USERNAME;
import static com.globant.challenge.wordpress.utilities.contants.SessionVariables.USER_LOGGED;

@AllArgsConstructor
public class Login implements Task {

  private User user;

  public static Login wordpress(User user){
    return Tasks.instrumented(Login.class, user);
  }

  @Step("{0} login Wordpress page")
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        WaitUntil.the(TXT_USERNAME, isVisible()).forNoMoreThan(2).seconds(),
        Enter.theValue(user.getEmail()).into(TXT_USERNAME),
        Click.on(BTN_SUBMIT)
    );

    actor.attemptsTo(
        WaitUntil.the(TXT_PASSWORD, isVisible()).forNoMoreThan(1).seconds(),
        Enter.theValue(user.getPassword()).into(TXT_PASSWORD),
        Click.on(BTN_SUBMIT)
    );

    Serenity.setSessionVariable(USER_LOGGED).to(user);
  }
}
