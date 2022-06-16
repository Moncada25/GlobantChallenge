package com.globant.challenge.wordpress.stepdefinitions.hooks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import io.cucumber.java.After;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BrowserHook {

  @After(order = 0)
  public void close() {

    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(2000));
    BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().close();
  }
}
