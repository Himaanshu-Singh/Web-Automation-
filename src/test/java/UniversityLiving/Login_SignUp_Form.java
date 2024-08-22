package UniversityLiving;

import PageData.Login_SignUp_Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Login_SignUp_Form {
    WebDriver driver;

    public Login_SignUp_Form(WebDriver driver) {
        this.driver = driver;
    }

    @Test(groups = {"checkURL"})
    public void checkURL() {
        Assert.assertEquals(driver.getTitle(), "Global Student Accommodation and Housing | University Living");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.universityliving.com/");
    }
    @Test(groups = {"LoginForm"})
    public void LoginFormData() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement loginbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Login_SignUp_Locators.loginbtn)));
        loginbtn.click();
        Thread.sleep(3000);

        WebElement crossbtn = driver.findElement(By.xpath(Login_SignUp_Locators.crossbtn));
        crossbtn.click();
        Thread.sleep(3000);

        WebElement signupbtn1 = driver.findElement(By.xpath(Login_SignUp_Locators.signupbtn));
        signupbtn1.click();
        Thread.sleep(3000);

        WebElement emailbtn = driver.findElement(By.xpath("//input[@id='email']"));
        emailbtn.click();
        emailbtn.sendKeys("pravin.garg@universityliving.com");
        Thread.sleep(3000);

        WebElement submitbtn = driver.findElement(By.xpath("//div[text()='Login']"));
        submitbtn.click();
        Thread.sleep(3000);

        WebElement btn1 = driver.findElement(By.xpath("(//input[@name='otp0'])[1]"));
        btn1.sendKeys("5");
        WebElement btn2 = driver.findElement(By.xpath("(//input[@name='otp1'])[1]"));
        btn2.sendKeys("4");
        WebElement btn3 = driver.findElement(By.xpath("(//input[@name='otp2'])[1]"));
        btn3.sendKeys("3");
        WebElement btn4 = driver.findElement(By.xpath("(//input[@name='otp3'])[1]"));
        btn4.sendKeys("2");
        WebElement btn5 = driver.findElement(By.xpath("(//input[@name='otp4'])[1]"));
        btn5.sendKeys("1");
        Thread.sleep(3000);

        WebElement submitbtn2 = driver.findElement(By.xpath("(//div[text()='Continue'])"));
        submitbtn2.click();
        Thread.sleep(5000);

        WebElement crosbtn = driver.findElement(By.xpath("(//*[name()='svg'][@class='w-4 h-4'])[1]"));
        crosbtn.click();
        Thread.sleep(3000);

    }
}
