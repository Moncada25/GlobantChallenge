package com.globant.challenge.wordpress.utilities;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import com.globant.challenge.wordpress.models.Environment;

import static com.globant.challenge.wordpress.utilities.ReadFiles.getEnvironment;

public final class DriverFactory {

  private static final String CHROME = "chrome";

  private DriverFactory() {
  }

  public static WebDriver getDriver() {

    Environment environment = getEnvironment("prod");

    WebDriver driver = (environment.getBrowser().equals(CHROME)) ? getChromeDriver() : getEdgeDriver();
    driver.get(environment.getUrl());
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    return driver;
  }

  private static WebDriver getChromeDriver() {

    ChromeOptions chromeOptions = new ChromeOptions();

    chromeOptions.addArguments(
        "--incognito",
        "--disable-infobars",
        "enable-automation",
        "--disable-browser-side-navigation");

    return WebDriverManager.chromedriver().capabilities(chromeOptions).create();
  }

  private static WebDriver getEdgeDriver() {

    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.setCapability("inprivate", true);

    return WebDriverManager.edgedriver().capabilities(edgeOptions).create();
  }
}
