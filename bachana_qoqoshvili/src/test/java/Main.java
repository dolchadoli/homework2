import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class Main {



    @Test
    public void fillPracticeForm() {




        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demoqa.com/automation-practice-form");


        driver.findElement(By.id("firstName")).sendKeys("bachana");
        driver.findElement(By.id("lastName")).sendKeys("qoqoshvili");
        driver.findElement(By.id("userEmail")).sendKeys("qoqoshvili@example.com");

        WebElement genderMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderMale);
        genderMale.click();


        driver.findElement(By.id("userNumber")).sendKeys("5551122330");

        driver.findElement(By.id("dateOfBirthInput")).click();

        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText("January");

        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("2004");

        driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[5]")).click();

        // Scroll to Subjects
        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subjectsInput);

// Type subject (Maths)
        subjectsInput.sendKeys("Maths");
        subjectsInput.sendKeys(Keys.ENTER);

// Add another subject (English)
        subjectsInput.sendKeys("English");
        subjectsInput.sendKeys(Keys.ENTER);



        WebElement hobbyMusic = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hobbyMusic);
        hobbyMusic.click();


        driver.findElement(By.id("currentAddress")).sendKeys("Tbilisi, Georgia");


        WebElement stateDropdown = driver.findElement(By.id("state"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateDropdown);
        stateDropdown.click();
        driver.findElement(By.xpath("//div[contains(text(),'NCR')]")).click();





        WebElement cityDropdown = driver.findElement(By.id("city"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cityDropdown);
        cityDropdown.click();
        driver.findElement(By.xpath("//div[contains(text(),'Delhi')]")).click();




        WebElement submitBtn = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));


        String popupText = driver.findElement(By.className("table-responsive")).getText();


        Assert.assertTrue(popupText.contains("bachana qoqoshvili"));
        Assert.assertTrue(popupText.contains("qoqoshvili@example.com"));
        Assert.assertTrue(popupText.contains("Male"));
        Assert.assertTrue(popupText.contains("5551122330"));
        Assert.assertTrue(popupText.contains("22 January,2004"));
        Assert.assertTrue(popupText.contains("Maths, English"));
        Assert.assertTrue(popupText.contains("Music"));
        Assert.assertTrue(popupText.contains("Tbilisi, Georgia"));
        Assert.assertTrue(popupText.contains("NCR Delhi"));






        driver.quit();






    }
}
