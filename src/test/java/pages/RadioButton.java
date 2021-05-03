package pages;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {
  private static final By ONE_WAY_RADIO_BUTTON =
      xpath("//*[@id='comlexRouteCollapse']//label[@data-target='#filter-tab_2-1']/parent::li");
  public WebDriver driver = new ChromeDriver();

  @Step("get one way radio button status after loading result page")
  public String getOneWayRadioButtonStatus() {
    driver.get("https://www.rw.by/");
    driver.manage().window().maximize();
   /* private static final By FROM_INPUT = id("acFrom");
    private static final By TO_INPUT = id("acTo");
    private static final By DATE_PICKER = id("yDate");
    private static final By SELECTED_DATE =
            cssSelector("#ui-datepicker-div td.ui-datepicker-days-cell-over.ui-datepicker-today");
    private static final By FIND_BUTTON = cssSelector("input[type='submit']");*/


    driver.findElement(By.id("acFrom")).sendKeys("Минск-Пассажирский");
    driver.findElement(By.id("acTo")).sendKeys("Молодечно");
    driver.findElement(By.id("yDate")).click();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement today = driver.findElement(By.xpath("//a[@date-code='today']"));
    js.executeScript("arguments[0].click();", today);


    driver.findElement(By.xpath("//input[@type='submit']")).click();

      /*$(DATE_PICKER).click();
      $(SELECTED_DATE).click();
      $(FIND_BUTTON).click();*/
    return driver.findElement(By.xpath("//*[@id='comlexRouteCollapse']//label[@data-target='#filter-tab_2-1']/parent::li")).getAttribute("class");
            //$(ONE_WAY_RADIO_BUTTON).attr("class");
  }
}
