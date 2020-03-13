package utililty;

public class Train {
  private String trainNumber;
  private String departureTime;
  private String minutes;

  public Train(String trainNumber, String departureTime, String minutes) {
    this.trainNumber = trainNumber;
    this.departureTime = departureTime;
    this.minutes = minutes;
  }

  @Override
  public String toString() {
    return "Train{"
        + "trainNumber='"
        + trainNumber
        + '\''
        + ", departureTime='"
        + departureTime
        + '\''
        + ", minutes='"
        + minutes
        + '\''
        + '}';
  }
}
