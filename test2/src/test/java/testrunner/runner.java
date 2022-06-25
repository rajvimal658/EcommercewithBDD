package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"classpath:feature"},glue={"stepdefinitions"},plugin= {"html:target/HTMLREPORTS.html"},
		monochrome = true,
		publish=true
        
		
		
		)

public class runner {

}
