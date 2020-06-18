MavenTestNG

Main Features of the Framework:

Parallel execution with multiple browsers.
Capability to run in docker with selenium grid
Integrated with Jenkins effortlessly.
Extent reporting which works in parallel runs.
Easy to use framework with Page object Model Design in which we have resuable methods which are stored in resuable package.

How to run the test using maven commands

Add surefire plugin in pom.xml file to run the maven test from command line.
mvn test
mvn test -Dbrowser.type=chrome to run the test on chrome browser.
mvn test -Dbrowser.type=firefox to run the test on firefox browser.
You can even run as mvn test which will trigger the testng.xml


How to run my scripts in local?

Open the config.properties file under com.config package and change the runmode to local.

How to run my scripts in Docker which is hosted in my local system?

Open the config.properties file under com.config package and change the value of runmode to remote and RemoteMode as Selenium.Remote URL should look like http://ipaddressofthemachine:4444/wd/hub