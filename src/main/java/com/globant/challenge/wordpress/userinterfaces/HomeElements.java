package com.globant.challenge.wordpress.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class HomeElements {

  private HomeElements() {
  }

  public static final Target BTN_MY_PROFILE = Target.the("button for my profile").locatedBy(
      "//a[@data-tip-target = 'me']"
  );

  public static final Target BTN_ACCOUNT_SETTINGS = Target.the("button for account settings").locatedBy(
      "//a[@href = '/me/account']"
  );

  public static final Target TXT_PROFILE_EMAIL = Target.the("generic span {0}").located(
      By.id("user_email")
  );
}
