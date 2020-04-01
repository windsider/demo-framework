# demo-task

How to Launch Tests

There are some ways to start tests

Before starting test clone the project from the repo

The first way to launch
1. go to the project root directory where pom file is
2. in cmd run 'mvn clean test' command
3. as an alternative of the previous command you can run 'mvn clean test -DsuiteXmlFile=testng.xml'

The second way to launch
1. open the cloned project in IntelliJ IDEA (File -> Open)
2. run file src/test/resources/testng.xml (right click on testng.xml -> run)

The third way to launch

Before using this way you should run testng.xml
1. open the cloned project in IntelliJ IDEA (File -> Open)
2. go src/test/tests/SearchResultTest.java
3. run this test class

To get allure test report after running tests in the project root directory run command 'mvn allure:serve' or in target directory run command 'allure serve'

In case of failed test screenshot is saved test-result/reports directory



