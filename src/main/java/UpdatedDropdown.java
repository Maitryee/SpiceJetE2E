import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class UpdatedDropdown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium jars and drivers\\Drivers\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");

        System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());//check friends& family is chkd or not
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();//check friends&family
        System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());//again chk
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();//uncheck frnds&family
        System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());//again chk
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());// find how many chk boxes are there in page

        System.out.println(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isEnabled());
        System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));//when radio button is not clicked the 'opcapacity' is 0.5, and when clicked it is 1.
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();//click on radio button
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));//now the opcapacity should be 1
   //to check if an element is enabled or disabled
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))// after clicking radio button if opcapacity=1, then test passes
        {
            System.out.println("its enabled");
            Assert.assertTrue(true);

        }
        else
            Assert.assertTrue(false);
    }
}
