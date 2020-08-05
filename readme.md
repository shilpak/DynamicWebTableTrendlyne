MavenTestNG

Main Features of the Framework:

Easy to use framework with Page object Model Design in which we have resuable methods which are stored in resuable package.

How to run the test using maven commands

mvn -Dbrowser.type=chrome test to run the test on chrome browser.

mvn -Dbrowser.type=firefox test to run the test on firefox browser.


Selenium Grid
This example demonstrate how to register the node to the hub.

Use the below code in your terminal
> java -jar selenium-server-standalone-<current version>.jar -role hub INFO - Launching Selenium Grid hub
Once the hub is ready to use use the url to register the node to the hub.

Open second terminal to register chrome node
> java -Dwebdriver.chrome.driver="chromedriver.exe" -jar selenium-server-standalone-"current version".jar -port 5555 -role node -hub 
http://"your machine ipaddress":4444/grid/register -browser "browserName=chrome, version=ANY, maxInstances=5, platform=ANY"

Open third terminal to register firefox node
> java -Dwebdriver.gecko.driver="geckodriver.exe" -jar selenium-server-standalone-"current version".jar -role node -hub http://"your machine ipaddress":4444/grid/register -port 5556 
-browser browserName=firefox,maxInstances=5,platform=ANY -maxSession 5

Open forth terminal to enter your project folder
mvn -Dbrowser.host=local test or -Dbrowser.host=grid test run the test in your environment.
