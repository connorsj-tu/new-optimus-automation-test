package com.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/optimus/features",
        glue = "com.step_definitions.optimus",

        //monochrome = true,
		// The following tags dictate which scenarios from each of the feature files in 
        // the project will be executed.  Note that tags prefixed with a ~ means that any
        // scenario with that tag will not be ran
        //
        // So for example if tags {"@optimus", "@numero", "@login", "~@wip", "~@ignore"} are 
        // set then any scenarios with all of the tags @optimus, @numero, and @login will 
        // be excluded, unless they also have one or more of the tags @wip and @ignore
        
        //		tags = {"@optimus", "@positive", "~@wip", "~@ignore"},
//      tags = {"@optimus", "~@wip", "~@ignore"},
//		tags = {"@optimus", "@login", "~@wip", "~@ignore"},
		tags = {"@optimus", "@numero", "@login", "~@wip", "~@ignore"},
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