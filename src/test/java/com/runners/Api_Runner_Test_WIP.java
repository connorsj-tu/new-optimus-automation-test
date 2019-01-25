package com.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/api/features",
        glue = "com.step_definitions.api",

        monochrome = true,

        tags = {"@api", "@optimus", "~@wip", "~@ignore"},
//		tags = {"@api", "@pen"},
        		
        		
        snippets = SnippetType.CAMELCASE,
        plugin = {
       			"pretty",
       			"html:target/cucumber",
       			"json:target/cucumber/cucumber.json",
       			"junit:target/cucumber/cucumber.xml"
        }
)


public class Api_Runner_Test_WIP {
}
