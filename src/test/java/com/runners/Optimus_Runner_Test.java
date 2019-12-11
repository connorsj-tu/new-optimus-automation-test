package com.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/optimus/features",
        glue = "com.step_definitions.optimus",

        monochrome = true,
		
//		tags = {"@optimus", "@positive", "~@wip", "~@ignore"},
//        tags = {"@optimus", "~@wip", "~@ignore"},
//		tags = {"@optimus", "@login", "~@wip", "~@ignore"},
		tags = {"@optimus", "@supplierportal", "@login", "~@wip", "~@ignore"},
//		tags = {"@optimus", "@supplierportal", "@basiccheck", "~@wip", "~@ignore"},
//		tags = {"@optimus", "@ginger", "@james","~@wip", "~@ignore"},
        		
        snippets = SnippetType.CAMELCASE,
        plugin = {
       			"pretty",
       			"html:target/cucumber",
       			"json:target/cucumber/cucumber.json",
       			"junit:target/cucumber/cucumber.xml"
        }
)


public class Optimus_Runner_Test {	
}