package pages;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

public class RadioButton {
  private static final By ONE_WAY_RADIO_BUTTON =
      xpath("//*[@id='comlexRouteCollapse']//label[@data-target='#filter-tab_2-1']/parent::li");

  @Step("get one way radio button status after loading result page")
  public String getOneWayRadioButtonStatus() {
    return $(ONE_WAY_RADIO_BUTTON).attr("class");
  }
}
