package com.inhahara.tests.testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/test/resources/Features", glue = "com.inhahara.tests.stepDefinitions")
public class TestRunner {

}
    