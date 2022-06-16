package com.globant.challenge.wordpress.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    glue = "com.globant.challenge.wordpress",
    features = "src/test/resources/features/auth/login.feature",
    snippets = SnippetType.CAMELCASE)
public class Login {}