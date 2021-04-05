import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClearTrip {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium jars and drivers\\Drivers\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("Adults")).click();
        //set passenger numbers-adult
        WebElement adults= driver.findElement(By.id("Adults"));
        Select passengerNum= new Select(adults);//the object 'adult' gets the capabilities of Select Class methods,so obj
                                                //passengerNum can now handle the Elements of Adults
        passengerNum.selectByValue("2");

        driver.findElement(By.id("Childrens")).click();
        //set passenger numbers-children
        WebElement child= driver.findElement(By.id("Childrens"));
        Select ChildrenNum= new Select(child);
        ChildrenNum.selectByValue("2");

        driver.findElement(By.id("DepartDate")).click();

        driver.findElement(By.xpath("//a[@id='MoreOptionsLink']")).click();


        WebElement travel=driver.findElement(By.id("Class"));
        Select travelClass = new Select(travel);
        travelClass.selectByValue("Business");

        driver.findElement(By.xpath("//input[@name='airline']")).sendKeys("indigo");
        driver.findElement(By.cssSelector("input#SearchBtn")).click();
        //validate error message
        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());



    }


}
