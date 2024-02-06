import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginTestPage{
    public static void main(String[] args){

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/Tejaswini/Downloads/chromedriver-119/chromedriver-win64/chromedriver.exe");

        // Launch the Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://rahulnxttrendz.ccbp.tech/login");

        // Find the username input element
        WebElement usernameEl = driver.findElement(By.id("username"));

        // Enter the username
        usernameEl.sendKeys("rahul");

        // Find the password input element
        WebElement passwordEl = driver.findElement(By.id("password"));

        // Enter the password
        passwordEl.sendKeys("rahul@2021");

        // Find the submit button element
        WebElement submitButtonElement = driver.findElement(By.className("login-button"));

        // Click the submit button
        submitButtonElement.submit();

        // Define the expected URL of the home page
        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/";

        // Wait for the expected URL to be loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        // Get the current URL after login
        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.equals(expectedUrl)){
            System.out.println("Navigation to home page was successful!");
        }else{
            System.out.println("Navigation to home page failed!");
        }

        // Quit the WebDriver instance
        driver.quit();

    }
}
