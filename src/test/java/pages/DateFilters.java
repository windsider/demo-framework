package pages;

import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;

import com.codeborne.selenide.ElementsCollection;

import io.qameta.allure.Step;

public class DateFilters {
  private static final By DATE_FILTER = By.className("sch-links__item");

  @Step("get list of date filters after loading result page")
  public ElementsCollection getListOfDateFilters() {
    return $$(DATE_FILTER);
  }
}
