package learn.BDD_TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions
		(	features = { "src/test/resources/AppFeatures/search.feature" }, 
			glue = {"learn.stepDefinations", "learn.BDD_Hooks" }, 
			plugin = { 	"pretty",
						"json:target/MyReports/report.json",
						"junit:target/MyReports/report.xml"
					 },
			//tags = "@smoke or "@regression",
					tags = "@regression",
			publish = true,
			monochrome = false,
			dryRun = true
		)

public class SearchRunnerTest {

	public static void main(String[] args) {
		
	}

}
