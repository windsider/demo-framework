package utililty;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static utililty.Config.get;
import static utililty.GridProvider.createChromeDriver;
import static utililty.GridProvider.createFireFoxDriver;

import static utililty.Log.getErrorLog;

import org.openqa.selenium.WebDriver;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;

public class Driver {
  private static WebDriver driver;

  public static void runRemote(String browser) {
    Configuration.clickViaJs = true;
    if (browser.equalsIgnoreCase("firefox")) {
      driver = createFireFoxDriver();
      setWebDriver(driver);
      open(get("url"));
    } else if (browser.equalsIgnoreCase("chrome")) {
      driver = createChromeDriver();
      setWebDriver(driver);
      open(get("url"));
    } else {
      getErrorLog("No driver found");
    }
  }

  public static void runLocal() {
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
}
