import com.sun.deploy.security.SelectableSecurityManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class E2E {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium jars and drivers\\Drivers\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        Thread.sleep(2000);

        //select radio button - one way-
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        //when we select oneway then 2nd calendar should be disabled
        driver.findElement(By.id("ctl00_mainContent_view_date2")).getAttribute("style");
        //check to see if 2nd calendar is disabled
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

        {
            System.out.println("2nd calendar is disabled");
            Assert.assertTrue(true);

        }
        else
            {
                Assert.assertTrue(false);
            System.out.println("2nd calendar is not disabled ");
        }
       //select chk box for friends & family
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();

        //click on FROM dropdown menu
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Select Bangalore as From city
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //click on TO dropdown menu and select Kolkata
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CCU']")).click();
        //Select today's date from calendar
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
        //Click on PASSENGERS dropdown menu
        driver.findElement(By.id("divpaxinfo")).click();

        //From Static dropdown menu -ADULT- select 2 adults
        WebElement adultsPassengers = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
        Select adults = new Select(adultsPassengers);
        adults.selectByValue("2");
        //From static dropdown menu CURRENCY select INR
        WebElement currencySelection =driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select currency=new Select(currencySelection);
        currency.selectByValue("INR");
        //click on SEARCH button
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        //Handle alert by switching to alert(), as this alert pop up is not HTML it is in java script and we have to switch from driver to alert()
        System.out.println(driver.switchTo().alert().getText());
        //this clicks on the 'OK' button on the alert popup
        driver.switchTo().alert().accept();
        //if there is a cancel button with OK button we can do the following: driver.switchTo().alert().dismiss();
        //after closing alert button again click dropdown for passengers and select 5 and click search and check whether it goes to correct page
        driver.findElement(By.id("divpaxinfo")).click();
        adults.selectByValue("5");
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

        // After clicking SEARCH button the next page which it goes to is chked here
        System.out.println(driver.getCurrentUrl());
        if (driver.getCurrentUrl().contains("https://book.spicejet.com/Select.aspx"))
        {
            Assert.assertTrue(true);
            System.out.println("This is the correct page");
        }
        else
            System.out.println("this is incorrect landing page");
            Set <String> windows=driver.getWindowHandles();//parent window/child window
             System.out.println("child window page: " + windows);
             /*Iterator <String> it = windows.iterator();//the object 'it' can extract the windows in the Ser Collection
             String parentID =it.next();//this has the parent id link
             String childID=it.next();
             driver.switchTo().window(childID);//this will move it to child window
        System.out.println(driver.findElement(By.cssSelector(".hide-mobile.float-left")).getText());*/










    }


}
