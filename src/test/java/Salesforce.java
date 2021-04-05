import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Salesforce {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium jars and drivers\\Drivers\\Chrome\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://login.salesforce.com/=");
        /*xpath syntax
        -> //tagname[@attribute='value']*/
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("maitryee.das@gmail.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("785783");//tagname=* ie take any attribute with given name
        driver.findElement(By.xpath("//input[@name='Login']")).click();//tagname=input,attribute=name,value=Login
        System.out.println("The error message is:"+driver.findElement(By.xpath("//div[@id='error']")).getText());
        driver.close();
    }
}
