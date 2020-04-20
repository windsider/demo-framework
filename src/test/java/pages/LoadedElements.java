package pages;

import com.browserup.harreader.model.HarEntry;

import com.codeborne.selenide.WebDriverRunner;

import java.util.List;

import io.qameta.allure.Step;

public class LoadedElements {

  @Step("get number of loaded png images on result page")
  public static long getNumberOfPageElements(String element) {

    final List<HarEntry> harEntries =
        WebDriverRunner.getSelenideProxy().getProxy().getHar().getLog().getEntries();

    final long numberOfLoadedElements =

            harEntries.stream()
                .filter(entry -> entry.getRequest().getUrl().contains(element))
                .count();
    return numberOfLoadedElements;
  }
}
