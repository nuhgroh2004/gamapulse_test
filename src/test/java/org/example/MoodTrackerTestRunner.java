package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/02_moodTracker.feature",
        glue = {"org.example.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-moodtracker-reports.html"},
        monochrome = true
)
public class MoodTrackerTestRunner {
}