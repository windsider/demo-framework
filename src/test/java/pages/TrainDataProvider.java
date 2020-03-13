package pages;

import static com.codeborne.selenide.Selenide.$$;
import static utililty.Log.getInfoLog;

import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;
import utililty.Train;

public class TrainDataProvider {
  private static final By LIST_OF_TRAINS = By.className("sch-table__row-wrap");
  private static final List<Train> TRAIN_DATA = new ArrayList<>();

  @Step("get number and departure time of listed trains")
  public List<Train> getRetievedTrainData() {
    for (SelenideElement train : $$(LIST_OF_TRAINS)) {
      String trainNumber = train.$(".train-number").text();
      String departureTime = train.$(".train-from-time").text();
      String minutesConverted = hoursToMinutes(departureTime);
      TRAIN_DATA.add(new Train(trainNumber, departureTime, minutesConverted));
    }
    return TRAIN_DATA;
  }

  public String hoursToMinutes(String hours) {
    final String[] timeInHours = hours.split(":");
    if (timeInHours.length != 2) {
      throw new ArrayIndexOutOfBoundsException();
    }

    final int minutes = (Integer.parseInt(timeInHours[0]) * 60) + Integer.parseInt(timeInHours[1]);
    return Integer.toString(minutes);
  }
}
