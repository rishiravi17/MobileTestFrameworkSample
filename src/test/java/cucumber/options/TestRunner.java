package cucumber.options;

import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"},
					glue = "stepdefinitions",
					strict = true,
					dryRun = false,
					monochrome = true,
					tags = "@TestFeature",
					plugin = {"pretty", "html:target/cucumber", "json:target/cukes.json", "junit:target/cukes.xml"})
@Listeners({externalresourcesrepository.Listener.class})
public class TestRunner extends AbstractTestNGCucumberTests {

}
