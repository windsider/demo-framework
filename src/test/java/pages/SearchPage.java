package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

public class SearchPage {
  private static final By FROM_INPUT = By.id("acFrom");
  private static final By TO_INPUT = By.id("acTo");
  private static final By DATE_PICKER = By.id("yDate");
  private static final By SELECTED_DATE =
      By.cssSelector("#ui-datepicker-div td.ui-datepicker-days-cell-over.ui-datepicker-today~td");
  private static final By FIND_BUTTON = By.cssSelector("input[type='submit']");

  @Step("select departure and arrival stations as well date")
  public void searchTrain(String departureStation, String arrivalStation) {
    $(FROM_INPUT).setValue(departureStation);
    $(TO_INPUT).setValue(arrivalStation);
    $(DATE_PICKER).click();
    $(SELECTED_DATE).click();
    $(FIND_BUTTON).click();
  }
}
