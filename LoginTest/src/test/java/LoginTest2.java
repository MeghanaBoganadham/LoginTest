
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//using ABSOLUTE XPATH

public class LoginTest2 {
    public static void main(String[] args) {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/Tejaswini/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        // Launch the Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Open the NxtTrendz login page
        driver.get("https://rahulnxttrendz.ccbp.tech/login");

        // Enter the username
        WebElement usernameEl =  driver.findElement(By.xpath("/html/body/div[1]/div/form/div[1]/input"));
        usernameEl.sendKeys("rahul");

        // Enter the password
        WebElement passwordEl = driver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/input"));
        passwordEl.sendKeys("rahul@2021");

        // Submit the login details
        WebElement buttonEl = driver.findElement(By.xpath("/html/body/div[1]/div/form/button"));
        buttonEl.submit();
        // Define the expected URL of the home page
        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/";

        // Wait for the expected URL to be loaded

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        // Get the current URL after login
        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.equals(expectedUrl)) {

            System.out.println("Navigation to home page was successful!");
        }

        else{
            System.out.println("Navigation failed");
        }

        // Quit the WebDriver instance
        driver.quit();

    }
}
