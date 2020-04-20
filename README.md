# demo-task

This is a demo project to test basic features of site for searching trains and booking tickets (https://www.rw.by/).

How to Launch Tests

Before starting test clone the project from the repo

There are two options to run tests: locally and remote.

To run locally in the test/resources/config file set the property testRunOption to 'local' value. This value is default.

To run remote:
1. install and start docker
2. download cm_windows_amd64.exe from https://github.com/aerokube/cm/releases
3. in cmd execute cm_windows_amd64.exe selenoid start --vnc
4. in cmd execute cm_windows_amd64.exe selenoid-ui start
5. in the config file set the property testRunOption to 'remote' value.


There are some ways to run tests

The first way to launch
1. go to the project root directory where pom file is located
2. in cmd run 'mvn clean test' command
3. as an alternative of the previous command you can run 'mvn clean test -DsuiteXmlFile=testng.xml'

The second way to launch
1. open the cloned project in IntelliJ IDEA (File -> Open)
2. run file src/test/resources/testng.xml or testng_FF_Chr_Parallel.xml for parallel testing (right click on testng.xml -> run)

To get allure test report after running tests in the project root directory run command 'mvn allure:serve' or in target directory run command 'allure serve'

In case of failed test a screenshot is saved in test-result/reports directory



