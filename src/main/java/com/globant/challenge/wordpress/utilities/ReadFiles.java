package com.globant.challenge.wordpress.utilities;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import com.globant.challenge.wordpress.models.Environment;
import com.globant.challenge.wordpress.models.User;

public final class ReadFiles {

  private static final EnvironmentVariables CONF = SystemEnvironmentVariables.createEnvironmentVariables();
  private static final String CONFIG_USER = "users.";
  private static final String CONFIG_ENVIRONMENT = "environments.";

  private ReadFiles() {
  }

  public static User getUser(String user) {

    return new User(
        CONF.getProperty(CONFIG_USER + user + ".email"),
        CONF.getProperty(CONFIG_USER + user + ".password")
    );
  }

  public static Environment getEnvironment(String environment) {

    return new Environment(
        CONF.getProperty(CONFIG_ENVIRONMENT + environment + ".url"),
        CONF.getProperty(CONFIG_ENVIRONMENT + environment + ".browser")
    );
  }
}
