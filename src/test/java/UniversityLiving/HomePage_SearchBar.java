package UniversityLiving;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePage_SearchBar {
    WebDriver driver;

    public HomePage_SearchBar(WebDriver driver){
        this.driver = driver;
    }

    @Test(groups = {"verifyPlaceholder"})
    public void SearchBarCheck() throws InterruptedException{
        WebElement searchbarbtm = driver.findElement(By.xpath("(//input[@placeholder='Search by City, University or Property'])[1]"));
        searchbarbtm.click();

        String placeholderactual = searchbarbtm.getAttribute("placeholder");

        String placeholderexpected =  "Search by City, University or Property";

        Assert.assertEquals(placeholderactual,placeholderexpected,"SearchBar Missing");
    }

    @Test(groups = {"Flags"})
    public void verifySearchFlagCountries() throws InterruptedException{
        //WebElement searchBarCounrtyflagbtn = driver.findElement(By.xpath("(//ul[@class='flex h-11 bg-gray-100 overflow-x-scroll no-scrollbar'])[1]"));
        WebElement firstFlag  = driver.findElement(By.xpath("(//li[@class='flex-grow flex items-center justify-center flag_countryFlag__nZR_S px-6 gap-2 text-center border-b-2 transition delay-300 content-font cursor-pointer hover:text-theme-orange text-theme-orange border-theme-orange bg-theme-orange-active/10 te-sc'])[1]"));
        WebElement lastFlag  = driver.findElement(By.xpath("(//li[@class='flex-grow flex items-center justify-center flag_countryFlag__nZR_S px-6 gap-2 text-center border-b-2 transition delay-300 content-font cursor-pointer hover:text-theme-orange hover:border-theme-orange-hover/25 te-sc'][normalize-space()='FRA'])[1]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(firstFlag)
                .moveToElement(lastFlag)
                .release()
                .perform();
    }

    @Test
    public void countFlags(){
        WebElement countFlagsbtn =  driver.findElement(By.xpath("(//ul[@class='flex h-11 bg-gray-100 overflow-x-scroll no-scrollbar'])[1]"));

        List<WebElement> allflags = countFlagsbtn.findElements(By.xpath(".//*"));
        String[] textToMatchFlags = {"UK", "AUS", "IRL","CAN","USA","GER","ITA","PRT","ESP","FRA"};

        for (String i : textToMatchFlags) {
            boolean found = false;
            for (WebElement j : allflags) {
                if (j.getText().equals(i)) {
                    found = true;
                    System.out.println("Matched text: " + i);
                    break;
                }
            }
            Assert.assertTrue(found, "Text '" + i + "' was not found in the header.");
        }

        List<WebElement> buttons = countFlagsbtn.findElements(By.tagName("button"));

        for (WebElement button : buttons) {
            System.out.println("Button text: " + button.getText());
        }
    }



}
