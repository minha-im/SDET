package TestRunner;

	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;
	//import org.testng.annotations.DataProvider;

	@CucumberOptions(
	    features = {"src/test/resources/Features"},
	    glue = {"StepsDefinition"},
	    plugin = {"pretty", "html:target/cucumber-reports"}
	)
	public class TestRunner extends AbstractTestNGCucumberTests {

	    //@Override
	    //@DataProvider(parallel = true)
	    //public Object[][] scenarios() {
	      //  return super.scenarios();
	    //}
	}

