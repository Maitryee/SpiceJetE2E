import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SpiceJetDropdown {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Selenium jars and drivers\\Drivers\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CCU']")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

       // driver.findElement(By.xpath("//body")).click();
        driver.findElement(By.id("divpaxinfo")).click();

        WebElement passengerAdult;
        passengerAdult=driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
        Select adults=new Select(passengerAdult);
        adults.selectByValue("2");


       WebElement passengerChild=driver.findElement(By.id("ctl00_mainContent_ddl_Child"));
        Select children=new Select(passengerChild);
        children.selectByValue("3");




       /* WebElement adultCount=driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
        Select passengerNumber=new Select(adultCount);
        passengerNumber.selectByValue("2");*/


    }
}
