package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
        tags = "", plugin = {"pretty" ,"html:target/cucumber", "json:target/cucumber.json"}, monochrome = true, dryRun = false)
public class runner {

}
