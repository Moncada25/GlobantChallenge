package com.globant.challenge.wordpress.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class LoginElements {

  private LoginElements() {
  }

  public static final Target TXT_USERNAME = Target.the("input field for username").located(
      By.id("usernameOrEmail")
  );

  public static final Target TXT_PASSWORD = Target.the("input field for password").located(
      By.id("password")
  );

  public static final Target BTN_SUBMIT = Target.the("button for submit").locatedBy(
      "//button[@type = 'submit']"
  );

  public static final Target LBL_ERROR = Target.the("label for login error").locatedBy(
      "//input[@id = 'password']/following::div[1]/span"
  );
}
