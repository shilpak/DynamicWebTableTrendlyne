# Selenium Project Configuration

Selenium Grid is a must know if you want to be a UI test automation engineer.  Almost every automation job requires a basic understanding of how it works.  So let’s walk through it.

Also, keep in mind I’m happy to explain these if you don’t understand why I’m asking for them.  **It is important to not only know how to do these things but also understand *WHY* we do them.  If you don't understand why please ask!**

## Step 1: Configuring and managing locally hosted browsers

I see that you’re including chromedriver.exe in almost all your projects.  Typically that’s not how it is done.  Everybody’s personal workspace is different.  You’re obviously on a Windows machine because you've included an .exe file.  I’m on a Mac so I can’t use that executable.  How I install chromedriver is very different than how you install chromedriver.  Somebody running Linux will install the driver differently as well.  The location of those binary executable files will be different on everybody's machine.

*Being able to run tests on a locally hosted browser is a VERY important requirement.  So we need to come up with a way to get this project to run multiple types of local browsers on any OS and any workspace configuration.*

**Also I’ve noticed that many of the things I’ve asked for are not getting done.  So let’s move back to a list of requirements.  I’ll expect each of the items below to be accomplished before we move on to the next step.**


1. This project should be configured as a Maven project, so all the tests in the project should be able to be run from the command line with the command `$ mvn test`.  [Use the Maven surefire plugin to accomplish this.](http://maven.apache.org/surefire/maven-surefire-plugin/usage.html)

2. The project’s tests can be executed with chrome and firefox by specifying which local browser driver the tests use by the command line Maven system property `$ mvn test -Dbrowser.type=chrome` and firefox via `$ mvn test -Dbrowser.type=firefox`.

4. Some sort of mechanism is provided (I suggest a configuration file of some sort) which allows consumers of the project to specify the absolute path to their chromedriver and geckodriver binary files on their local machines.  The framework will then read those values and use them when launching the requested browser driver for the tests to execute on.

5. A README.md file is added to the root of the project.  It should contain instructions which guide developers on how to accomplish #3 above.

6. The chromedriver binary is removed from the project.

7. The ./bin directory is removed from the project.  (We’ve already talked about why we do not include compiled files in the project.)
