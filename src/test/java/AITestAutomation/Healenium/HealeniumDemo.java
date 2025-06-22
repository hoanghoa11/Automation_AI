package AITestAutomation.Healenium;


import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HealeniumDemo {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver delegate = new ChromeDriver(options);
        SelfHealingDriver driver = SelfHealingDriver.create(delegate);

        try {
            driver.get("file:///C://Users//Admin//IdeaProjects//Test_Automation//loginpage.html"); // Change this to your test URL
            WebElement element = driver.findElement(By.id("usernamee"));
            element.sendKeys("abc");
            Thread.sleep(3000);
            element.isDisplayed();

        } catch (Exception e) {
            System.out.println("Element not found, Healenium may attempt to heal the locator if trained before.");
        } finally {
            driver.quit();
        }
    }
}
