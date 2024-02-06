import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginTest {
    public static void main(String[] args){
        //set the path to thr ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/Tejaswini/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        //open Chrome browser
        WebDriver driver = new ChromeDriver();

        //navigate to the given url
        //driver.get("https://www.flipkart.com");
        driver.get("https://rahulnxttrendz.ccbp.tech/login");

        //Find the username element
        WebElement usernameEl = driver.findElement(By.id("username"));
        usernameEl.sendKeys("rahul");
        //usernameEl.sendKeys("rahulll");


        //Find the password element
        WebElement passwordEl = driver.findElement(By.id("password"));
        passwordEl.sendKeys("rahul@2021");

        //Find the submit button
        WebElement loginButtonEl = driver.findElement(By.className("login-button"));
        loginButtonEl.submit();

        //Expected URL
        String exceptedUrl = "https://rahulnxttrendz.ccbp.tech/";

        //Before the current URL gets updated
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(exceptedUrl));

        //Current URL
        String currentUrl =  driver.getCurrentUrl();

        //check Validation
        if(currentUrl.equals((exceptedUrl))) {
            System.out.println("Navigation to home page was Successfull");
        }

        else {
            System.out.println("Navigation to home page failed!!");
        }

        //get the webpage title
        //String title = driver.getTitle();
        //System.out.println(title);

        //close the browser
        driver.quit();
    }
}
