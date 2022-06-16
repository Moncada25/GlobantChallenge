package com.globant.challenge.wordpress.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static com.globant.challenge.wordpress.userinterfaces.LoginElements.LBL_ERROR;

public class TheError implements Question<String> {

  public static TheError message() {
    return new TheError();
  }

  @Subject("validate the error message")
  @Override
  public String answeredBy(Actor actor) {

    actor.attemptsTo(
        WaitUntil.the(LBL_ERROR, isVisible()).forNoMoreThan(2).seconds()
    );

    return Text.of(LBL_ERROR).answeredBy(actor);
  }
}
