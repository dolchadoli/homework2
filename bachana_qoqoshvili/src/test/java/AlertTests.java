import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTests {

    @Test
    public void alertWithTextboxTest()  {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demo.automationtesting.in/Alerts.html");

        // Click tab: "Alert with Textbox"
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();

        // Click button to trigger alert
        driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]"))
                .click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();


        String name = "bachana qoqoshvili";


        alert.sendKeys(name);
        alert.accept();


        String result = driver.findElement(By.id("demo1")).getText();

        Assert.assertTrue(result.contains(name),
                "Expected result to contain the submitted name, but got: " + result);


        driver.quit();
    }
}
