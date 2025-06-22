package AITestAutomation.OpenCV;

import com.hoa.drivers.DriverManager;
import com.hoa.keywords.WebUI;
import common.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class CaptureScreenshot extends BaseTest {

        @Test
        public void takeScreenshot() {
            WebUI.openURL("http://192.168.255.217:8089/buckets");
            WebUI.waitForPageLoaded();

            // Rất nên chờ 1 phần tử chính nào đó có mặt
            WebUI.waitForElementVisible(By.xpath("//p[normalize-space()='Sources']"), 10);

            // Tạm nghỉ thêm 1 chút cho chắc
            WebUI.sleep(2);

            // Chụp ảnh
            File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            screenshot.renameTo(new File("current.png"));
        }

}
