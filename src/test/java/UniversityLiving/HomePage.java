package UniversityLiving;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1); // 1: Allow, 2: Block
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized"); // Open browser in maximized mode
        options.addArguments("--disable-infobars"); // Disabling info bars
        options.addArguments("--disable-notifications"); // Disabling notifications
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkTheUrl() throws InterruptedException {
        driver.get("https://www.universityliving.com/");
        driver.manage().window().maximize();
        Thread.sleep(4000);

        // Create an instance of Login_SignUp_Form and call checkURL method
        Login_SignUp_Form loginForm = new Login_SignUp_Form(driver);
        loginForm.checkURL();

        Login_SignUp_Form loginFormDialog = new Login_SignUp_Form(driver);
        loginFormDialog.LoginFormData();

        HomePageTopBar CheckTopBarElement = new HomePageTopBar(driver);
        CheckTopBarElement.CheckTopBarElements();

        HomePage_SearchBar searchbar = new HomePage_SearchBar(driver);
        searchbar.SearchBarCheck();

        Thread.sleep(3000);
        HomePage_SearchBar flagVerify = new HomePage_SearchBar(driver);
        flagVerify.verifySearchFlagCountries();

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 500);");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
