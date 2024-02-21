package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="DilpreetSinghLearning.StepDefinitions" //these are all the helper attributes
,monochrome=true, tags= "@ErrorValidationTwo", plugin= {"html:target/cucumber.html"})     //glue attribute is to give the path of step definitions file in the framework
                     
//output of cucumber will come in encoded format the results will not be in readable but monochrome attribute will give the results in readable format
//to generate the report in html format we have to give the details in plugin attribute and should provide the path also where the report should be saved
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	
	

}
