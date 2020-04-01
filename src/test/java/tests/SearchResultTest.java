package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static utililty.Log.infoLog;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.testng.ScreenShooter;

import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utililty.BaseSetup;
import pages.DateFilters;
import pages.LoadedElements;
import pages.RadioButton;
import pages.ERegistrationFunction;
import pages.SearchPage;
import pages.TrainDataProvider;

@Listeners({ScreenShooter.class})
public class SearchResultTest extends BaseSetup {
  @Parameters({"departureStation", "arrivalStation"})
  @BeforeClass(alwaysRun = true)
  public void beforeClass(String departureStation, String arrivalStation) {
    new SearchPage().searchTrain(departureStation, arrivalStation);
  }

  @Test(description = "verifying default status of one way radio button is active")
  @Severity(SeverityLevel.MINOR)
  public void testOneWayRadioButtonStatus() {
    final String radioButtonStatus = new RadioButton().getOneWayRadioButtonStatus();
    Assert.assertTrue(radioButtonStatus.contains("active"));
  }

  @Test(description = "verifying status of electronic registration checkbox after checking it")
  @Severity(SeverityLevel.NORMAL)
  public void testERegistrationCheckBoxStatus() {
    final String checkBoxStatus =
        new ERegistrationFunction().checkERegistrationCheckbox().getERegistrationCheckBoxStatus();
    Assert.assertTrue(checkBoxStatus.contains("checked"));
  }

  @Test(
      description =
          "verifying only trains with electronic registration icon are listed after checking ER checkbox")
  @Severity(SeverityLevel.NORMAL)
  public void testListingTrainsWithERegistrationIcon() {
    new ERegistrationFunction()
        .checkERegistrationCheckbox()
        .getListOfTrainsWithERegistrationIcon()
        .forEach(train -> Assert.assertTrue(train.innerHtml().contains("svg-tag-er")));
  }

  @Test(description = "verifying visibility and number of date filters on result page")
  @Severity(SeverityLevel.CRITICAL)
  public void testDateFiltersVisibility() {
    new DateFilters().getListOfDateFilters().filter(Condition.visible).shouldHave(size(4));
  }

  @Test(description = "displaying number and departure time of listed trains")
  @Severity(SeverityLevel.CRITICAL)
  public void testDisplayingTrainNumberAndDepartureTime() {
    new TrainDataProvider()
        .getRetievedTrainData()
        .forEach(
            train -> {
              infoLog(train.toString());
              Assert.assertTrue(train.toString().contains("trainNumber"));
              Assert.assertTrue(train.toString().contains("departureTime"));
              Assert.assertTrue(train.toString().contains("minutes"));
            });
  }

  @Parameters({"element"})
  @Test(description = "verifying number of loaded png images is greater 5")
  @Flaky
  @Severity(SeverityLevel.MINOR)
  public void testNumberOfLoadedImages(String element) {
    final int numberOfLoadedImages = new LoadedElements().getNumberOfPageElements(element);
    Assert.assertTrue(numberOfLoadedImages > 5);
  }
}
