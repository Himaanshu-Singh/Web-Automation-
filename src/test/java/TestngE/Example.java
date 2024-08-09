package TestngE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Example {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
    }
    @Test
    void checkTheUrl() throws InterruptedException {

        driver.get("https://www.universityliving.com/");
        String url = driver.getCurrentUrl();
        WebElement btn = driver.findElement(By.xpath("//a[text()=\"Services\"]"));
        btn.click();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        WebElement btn2 = driver.findElement(By.xpath("//div[text()=\"Explore All Services\"]"));
        btn2.click();
        Thread.sleep(2000);
       // WebElement crossbtn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]"));//cross btn of signup form
        WebElement btn3 = driver.findElement(By.xpath("(//p[text()='Accommodation'])[2]"));
        btn3.click();
        Thread.sleep(7000);
    }
//    @AfterTest
//    void tearDown() {
//        driver.quit();
//    }
}