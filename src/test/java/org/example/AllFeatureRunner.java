package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/01_login.feature"
                , "src/test/resources/features/02_moodTracker.feature"
                , "src/test/resources/features/03_dailyTaskLog.feature"
                , "src/test/resources/features/04_studentReport.feature",
                "src/test/resources/features/05_createUser.feature",
                "src/test/resources/features/06_permissionRequest.feature"
        },
        glue = {"org.example.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber/create-user-report.html"},
        monochrome = true
)
public class AllFeatureRunner {
}