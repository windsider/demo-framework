package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

import com.codeborne.selenide.ElementsCollection;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

public class ERegistrationFunction {
  private static final By E_REGISTRATION_CHECK_BOX =
      xpath("//*[@id='sch-filter-main-collapse']//span[@data-filter-value='eregistration']");
  private static final By E_REGISTRATION_CHECK_BOX_STYLER =
      xpath("//input[@name='form-ER']/parent::div");
  private static final By LIST_OF_DISPLAYED_TRAINS =
      cssSelector(".sch-table__row-wrap:not(.hidden)");

  @Step("check electronic registration checkbox")
  public ERegistrationFunction checkERegistrationCheckbox() {
    if (!$(E_REGISTRATION_CHECK_BOX_STYLER).attr("class").contains("checked")) {
      $(E_REGISTRATION_CHECK_BOX).click();
    }
    return this;
  }

  @Step("get status of electronic registration checkbox")
  public String getERegistrationCheckBoxStatus() {
    return $(E_REGISTRATION_CHECK_BOX_STYLER).attr("class");
  }

  @Step("get listed trains")
  public ElementsCollection getListOfTrainsWithERegistrationIcon() {
    return $$(LIST_OF_DISPLAYED_TRAINS);
  }
}
