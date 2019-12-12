# Optimus Automation

The maven-automation_test_suite project allows automated running of tests against Optimus.

## Maven Project

* Install Eclipse, create an empty workspace then import this project as a Maven project.  Dependencies will then install, as defined in the pom.xml file.
* Scripts can be executed using runners under \src\test\java\com\runners
* Adjust tags in the runner file to dictate which scenarios are executed.  The following will execute all scenarios with @login and @positive tags and which do not have @wip or @ignore tags: tags = {"@login", "@positive", "~@wip", "~@ignore"}

## Useful Eclipse Plug-ins

### Cucumber Plugin
* Launch the Eclipse IDE and from Help menu, click "Install New Software" button.
* You will see a dialog window, click "Add" button.
* Type name as you wish, e.g. "Cucumber" and type "http://cucumber.github.com/cucumber-eclipse/update-site" as location. Click OK.
* You come back to the previous window but this time you must see Cucumber Eclipse Plugin option in the available software list. Check the box and press "Next" button.
* Accept any defaults and complete the plugin installation

### ANSI Escape in Console
Enables colour console output in Eclipse.
* Install "ANSI Escape in Console" from Help > Eclipse Marketplace


## Entry point runners

There is currently 1 runner available to be used as entry points

* Optimus_Runner_Test - the default
