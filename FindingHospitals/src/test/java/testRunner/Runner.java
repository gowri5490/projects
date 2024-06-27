package testRunner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(
		features = {"src/test/java/features/Schedule.feature"},
		dryRun = !true,
		glue = {"feature","steps"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		plugin = {"pretty","html:reports"}
		)

@Test(priority = 1000)
public class Runner extends AbstractTestNGCucumberTests
{
	
}
