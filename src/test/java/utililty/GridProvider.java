package utililty;

import static org.openqa.selenium.firefox.FirefoxDriver.PROFILE;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;;
import org.openqa.selenium.firefox.FirefoxProfile;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static utililty.Config.get;

public class GridProvider {

  public static final String hubUrl = get("hubUrl");

  public static WebDriver createChromeDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");

    try {
      return new RemoteWebDriver(new URL(hubUrl), options);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  public static WebDriver createFireFoxDriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    FirefoxProfile firefoxProfile = new FirefoxProfile();

    firefoxProfile.setPreference("browser.fullscreen.autohide", true);
    firefoxProfile.setPreference("browser.fullscreen.animateUp", 0);

    capabilities.setCapability(PROFILE, firefoxProfile);
    capabilities.setBrowserName("firefox");
    try {
      return new RemoteWebDriver(new URL(hubUrl), capabilities);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }
}
