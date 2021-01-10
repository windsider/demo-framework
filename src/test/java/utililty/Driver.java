package utililty;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static utililty.Config.get;
import static utililty.GridProvider.createChromeDriver;
import static utililty.GridProvider.createFireFoxDriver;
import static utililty.Log.getErrorLog;

public class Driver {
    private static WebDriver driver;

    public static void runRemote(String browser) {
        Configuration.clickViaJs = true;
        if (browser.equalsIgnoreCase("firefox")) {
            driver = createFireFoxDriver();
            setWebDriver(driver);
            open(get("url"));
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver =createChromeDriver();
            setWebDriver(driver);
            open(get("url"));
        } else {
            getErrorLog("No driver found");
        }
    }

    public static void runLocal() {
        Configuration.fastSetValue = true;
        Configuration.clickViaJs = true;
        Configuration.proxyEnabled = true;
        Configuration.reportsFolder = get("reportsFolder");
        SelenideLogger.addListener(
                "AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        startMaximized = true;
        Selenide.open(get("url"));
    }
}
