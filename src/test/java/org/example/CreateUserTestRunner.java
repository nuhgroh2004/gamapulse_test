package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/createUser.feature",
        glue = {"org.example.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber/create-user-report.html"},
        monochrome = true
)
public class CreateUserTestRunner {
}