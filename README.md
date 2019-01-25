# Kalibrate Automation

The Kalibrate-Automation project allows automated running of tests against an instance of Kalibrate-UI.

## Maven Project

* Install Eclipse, create an empty project then import this project as a Maven project.  Dependencies will then install, as defined in the pom.xml file.
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

## Prerequisites

- [Docker for Windows](https://www.docker.com/docker-windows) (set to run windows containers)

## Building Docker Image

```powershell
git clone git@github.com:KalibrateTechnologies/Kalibrate-Automation.git
```

```powershell
cd Kalibrate-Automation
```

```powershell
.\docker\Dockerbuild.ps1
```
## Running Docker Container

```powershell
.\docker\Dockerrun.ps1 -URL <URL> -USER <USER> -PWD <PWD>
```

* `-URL` is the parameter that specifies and points to the instance of Kalibrate-UI that the tests will be using.
* `-USER` & `-PWD` are optional parameters that specify the login credentials for Kalibrate-UI. If not specified, these have default values.


## Entrypoint runners

There are currently 3 runners available to be used as entry points

* Kalibrate_Runner_Test - the default
* Api_Runner_Test - a runner to run api tests
* KMobileWeb_Runner_Test - a runner for KMobile Web