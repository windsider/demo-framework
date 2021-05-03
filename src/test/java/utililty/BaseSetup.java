package utililty;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.RadioButton;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utililty.Config.get;
import static utililty.Driver.runLocal;
import static utililty.Driver.runRemote;
import static utililty.Log.infoLog;

public class BaseSetup {
    final String testRunOption = get("testRunOption");

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browser) {
        if (testRunOption.equals("remote")) {
            runRemote(browser);
        } else if (testRunOption.equals("local")) {
            runLocal();
        } else {
            infoLog("Select test run option: remote or local");
        }
    }

    @AfterTest
    public void tearDown() {
        RadioButton radioButton = new RadioButton();
        radioButton.driver.quit();
        closeWebDriver();

    }
}
