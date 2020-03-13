package pages;

import static utililty.ProxySetup.getProxyServer;

import com.browserup.harreader.model.HarEntry;

import java.util.List;

import io.qameta.allure.Step;

public class LoadedElements {

  @Step("get number of loaded png images on result page")
  public int getNumberOfPageElements(String element) {
    final List<HarEntry> harEntries = getProxyServer().getProxy().getHar().getLog().getEntries();
    final int numberOfLoadedElements =
        (int)
            harEntries.stream()
                .filter(entry -> entry.getRequest().getUrl().contains(element))
                .count();
    return numberOfLoadedElements;
  }
}
