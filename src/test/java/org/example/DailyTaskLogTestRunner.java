package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/03_dailyTaskLog.feature",
        glue = {"org.example.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-dailytasklog-reports.html"},
        monochrome = true
)
public class DailyTaskLogTestRunner {
}