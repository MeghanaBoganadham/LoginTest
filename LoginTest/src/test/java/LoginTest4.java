
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

// XPATH FUNCTIONS
import java.time.Duration;

public class LoginTest4 {
    public static void main(String[] args) {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/Tejaswini/Downloads/chromedriver-119/chromedriver-win64/chromedriver.exe");

        // Launch the Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Open the NxtTrendz login page
        driver.get("https://rahulnxttrendz.ccbp.tech/login");

        // Find and fill in the form fields
        WebElement usernameEl = driver.findElement(By.xpath("//input[@id='username']"));
        usernameEl.sendKeys("rahul");

        WebElement passwordEl = driver.findElement(By.xpath("//input[@id='password']"));
        passwordEl.sendKeys("rahul@2021");

        WebElement buttonEl = driver.findElement(By.xpath("//button[@type='submit']"));
        buttonEl.submit();

        // Define the expected URL of the home page
        String homePageUrl = "https://rahulnxttrendz.ccbp.tech/";

        // Wait for the expected URL to be loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(homePageUrl));

        // Get the current URL after login
        String currentUrl1 = driver.getCurrentUrl();

        if (currentUrl1.equals(homePageUrl)) {

            System.out.println("Navigation to home page was successful!");
        } else {
            System.out.println("Navigation to home page was not successful!");
        }


        // Find and click on the "Shop Now" button
        WebElement shopNowButtonEl = driver.findElement(By.xpath("//button[@class='shop-now-button']"));
        shopNowButtonEl.click();

        // Define the expected URL of the products page
        String productsPageUrl = "https://rahulnxttrendz.ccbp.tech/products";

        // Get the current URL after navigation to products page
        String currentUrl2 = driver.getCurrentUrl();
        if (currentUrl2.equals(productsPageUrl)) {
            System.out.println("Navigation to products page was successful!");
        } //else {
            //System.out.println("Navigation to products page was not successful!");
        //}


        //Wait until elements are displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='products-item']")));

        // Verify the display of products on the products page
        List<WebElement> products = driver.findElements(By.xpath("//li[@class='product-item']"));

        if (products.size() > 0) {
            System.out.println("Products are displayed successfully on the products page: " + products.size());

            //Select the product with text as Minifigures
            WebElement productNameEle = driver.findElement(By.xpath("//h1[text() = 'Minifigures']"));
            String expectedProductTitle = productNameEle.getText();
            productNameEle.click();

            String productDetailsUrl = "https://rahulnxttrends.ccbp.tech/products/1002";
            wait.until(ExpectedConditions.urlToBe(productDetailsUrl));


            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals(productDetailsUrl)) {
                System.out.println("Navigation to the Product Details Page is Successful...!!");

                //} else {
                //System.out.println("Navigation to the Product Details Page is  NOT Successful...!!");

            }wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-details-success-view']")));


        } else {
            System.out.println("No products found on the products page.");
        }
    }
}