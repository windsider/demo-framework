package utililty;

import static com.codeborne.selenide.WebDriverRunner.getSelenideProxy;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.proxy.SelenideProxyServer;

public class ProxySetup {
  private static final SelenideProxyServer proxyServer = getSelenideProxy();

  public static SelenideProxyServer getProxyServer() {
    WebDriverRunner.setProxy(proxyServer.createSeleniumProxy());
    return proxyServer;
  }
}
