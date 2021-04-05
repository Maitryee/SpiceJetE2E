import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium jars and drivers\\Drivers\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nike.com/ca/");//hit url on the browser
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.getTitle());//validate if the page title is correct
        System.out.println(driver.getCurrentUrl());//validate if you have landed on correct url
        driver.navigate().to("https://www.yahoo.com");
        driver.navigate().back();
        //driver.close();//closes the current Browser
        driver.quit();// closes all the browsers opened by selenium script
    }
}


