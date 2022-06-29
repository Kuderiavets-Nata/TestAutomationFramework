# Test Automation Framework
The framework based on Java, TestNG, Appium, Jmeter
Great for testing cross-platform application 


#### For usin this framework you need: 

 - Java version 1.8 or higher 
 - Maven, Appium server installed on the machine
 - Download framework from Git and unzip it
 - Ensure that the Lombok plugin is installed. 
 - Add "Configuration.properties" file at src/main/java/configs/Configuration.properties for successful login 
 ![Screen Shot 2022-06-29 at 19 08 46 PM](https://user-images.githubusercontent.com/73226595/176484262-973ff562-1049-4a1c-92cc-8a4a1e355c57.png)
 - For running test on your smartphone change capabilities at setup() -> setup() ->src/main/java/pages/mobile/base/BasePage.java 
 - Use "mvn clean install" in the terminal for a successful build. 
 - Use "allure serve allure-results" in the terminal to generate an allure report.



