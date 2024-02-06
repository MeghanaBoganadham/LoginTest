
import org.openqa.selenium.WebElement;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationTest{
    public static void main(String[] args){

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/Tejaswini/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        // Launch the Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Open the NxtTrendz registration page
        driver.get("https://rahulnxttrends.ccbp.tech/login");

        // Find the username input element
        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("Meghana Boganadham");

        // Find the email input element
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("meghanaboganadham@gmail.com");
        // Find the password input element
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Minnu@992121");

        // Find the male radio button
        WebElement genderField = driver.findElement(By.id("female"));
        genderField.click();

        // Find the country dropdown element
        WebElement countryDropdown = driver.findElement(By.tagName("select"));
        Select countrySelect = new Select(countryDropdown);

        // Select an option by visible text
        countrySelect.selectByVisibleText("India");

        //T&C
        WebElement termsandconditions = driver.findElement(By.id("terms"));
        termsandconditions.click();

        //Submit Registration
        WebElement registrationButton = driver.findElement(By.id("submitBtn"));
        registrationButton.submit();

        //Navigate to LoginPage
        WebElement LoginPageEl = driver.findElement(By.linkText("Log in"));
        LoginPageEl.click();


        ///have to check once!!!!!!!!!!!!!!11
        //Before the current URL gets updated
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));

        //Check navigation
        String loginPageUrl = "https://rahulnxttrends.ccbp.tech/login";
        String currentUrl = driver.getCurrentUrl();

        //check Validation
        if(currentUrl.equals(loginPageUrl)) {
            System.out.println("Navigation to home page was Successfull");
        }

        else {
            System.out.println("Navigation to home page failed!!");
        }

    }
}