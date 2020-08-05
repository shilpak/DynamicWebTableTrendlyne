# Selenium Project Configuration

Selenium Grid is a must know if you want to be a UI test automation engineer.  Almost every automation job requires a basic understanding of how it works.  So let’s walk through it.

**It is important to not only know how to do these things but also understand *WHY* we do them.  If you don't understand why please ask!**


1.  Add selenium grid support.  Use the config file to store the url of the grid.

2. A new command line argument is available `-Dbrowser.host` which allows user to specify where the browser will be launched.

3. A user can specify running locally with `-Dbrowser.host=local` or on a pre-defined selenium hub with `-Dbrowser.host=grid`.
