package UniversityLiving;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTopBar { WebDriver driver;

    public HomePageTopBar(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void CheckTopBarElements() throws InterruptedException {
        WebElement header = driver.findElement(By.xpath("//nav[@class='hidden space-x-7 lg:flex items-stretch']"));
        Thread.sleep(1000);

        List<WebElement> elements = header.findElements(By.xpath(".//*"));
        String[] textsToMatch = {"Cost of Living", "Find My Kinda Room", "Services"};

        for (String text : textsToMatch) {
            boolean found = false;
            for (WebElement element : elements) {
                if (element.getText().equals(text)) {
                    found = true;
                    System.out.println("Matched text: " + text);
                    break;
                }
            }
            Assert.assertTrue(found, "Text '" + text + "' was not found in the header.");
        }

        List<WebElement> buttons = header.findElements(By.tagName("button"));

        for (WebElement button : buttons) {
            System.out.println("Button text: " + button.getText());
        }
    }
}