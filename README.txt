Maven Project
-------------

Install Eclipse, create an empty project then import this project as a Maven project.  Dependencies will then install, as defined in the pom.xml file.

Scripts can be executed using runners under \src\test\java\com\runners

Adjust tags in the runner file to dictate which scenarios are executed.  The following will execute all scenarios with @login and @positive tags and which do not have @wip or @ignore tags; 

	tags = {"@login", "@positive", "~@wip", "~@ignore"},




Useful Eclipse Plug-ins
----------------------

CUCUMBER PLUGIN
1) Launch the Eclipse IDE and from Help menu, click "Install New Software" button.
2) You will see a dialog window, click "Add" button.
3) Type name as you wish, e.g. "Cucumber" and type "http://cucumber.github.com/cucumber-eclipse/update-site" as location. Click OK.
4) You come back to the previous window but this time you must see Cucumber Eclipse Plugin option in the available software list. Check the box and press "Next" button.
5) Accept any defaults and complete the plugin installation


ANSI Escape in Console
To enable colour console output in Eclipse;
1)	Install "ANSI Escape in Console" from Help > Eclipse Marketplace