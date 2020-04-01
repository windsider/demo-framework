package utililty;

import static utililty.Config.get;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Configuration.baseUrl;;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;

public class BaseSetup {

  @BeforeTest
  public void setUp() {
    System.setProperty(get("webdriver"), get("webdriverPath"));
    System.setProperty(get("browserProperty"), get("browser"));
    baseUrl = get("url");
    Configuration.fastSetValue = true;
    Configuration.clickViaJs = true;
    Configuration.proxyEnabled = true;
    Configuration.reportsFolder = get("reportsFolder");
    SelenideLogger.addListener(
        "AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    startMaximized = true;
    open(baseUrl);
  }

  @AfterTest
  public void tearDown() {
    closeWebDriver();
  }
}
