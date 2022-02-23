package testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features="Features/OrangeHRMLogin.feature",

glue= {"stepDefinitions"},

plugin = {"pretty",
        "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/CucumberTestReport.json",
        "rerun:target/cucumber-reports/rerun.txt"},


tags= {"@ValidationTesting"},

monochrome = true)

public class TestRunnerClass
{
	
	    private TestNGCucumberRunner testNGCucumberRunner;
     
	    @BeforeClass(alwaysRun=true)
	    public void setUpClass() throws Exception 
	    {
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    }
	     
	    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	    public void feature(CucumberFeatureWrapper cucumberFeature) 
	    {
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	    }
	 
	    @DataProvider
	    public Object[][] features() 
	    {
	        return testNGCucumberRunner.provideFeatures();
	    }
	      
	   	     
	    @AfterClass(alwaysRun=true)
	    public void tearDown()
	    {
	    	
	        testNGCucumberRunner.finish();
	         
	    }

  }
