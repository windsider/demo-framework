package pages;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

public class SearchPage {
  private static final By FROM_INPUT = id("acFrom");
  private static final By TO_INPUT = id("acTo");
  private static final By DATE_PICKER = id("yDate");
  private static final By SELECTED_DATE =
      cssSelector("#ui-datepicker-div td.ui-datepicker-days-cell-over.ui-datepicker-today");
  private static final By FIND_BUTTON = cssSelector("input[type='submit']");

  @Step("select departure and arrival stations as well date")
  public void searchTrain(String departureStation, String arrivalStation) {
    $(FROM_INPUT).setValue(departureStation);
    $(TO_INPUT).setValue(arrivalStation);
    $(DATE_PICKER).click();
    $(SELECTED_DATE).click();
    $(FIND_BUTTON).click();
  }
}
