package snippet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2 {

	public static void main(String[] args) {
        // Set path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.automationanywhere.com/");
        driver.manage().window().maximize();
       
        //driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //
        try {
            WebElement consentButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
            consentButton.click();
            System.out.println("Clicked on consent button.");
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Cookie consent banner did not appear.");      
        }

        verifyAndClickLink(driver, "productsNav");
        verifyAndClickLink(driver, "solutionsNav");        
        verifyAndClickLink(driver, "resourcesNav");
        verifyAndClickLink(driver, "customersNav");      	      
        verifyAndClickLink(driver, "companyNav");              
        
        driver.quit();
    }

    // Method to verify and click on a link
    private static void verifyAndClickLink(WebDriver driver, String linkText) {
    	 WebElement link = driver.findElement(By.xpath("//li[contains(@class, '" + linkText + "')]"));
        if (link.isDisplayed()) {
            System.out.println("Link '" + linkText + "' is present.");
            link.click();
            System.out.println("Navigated to: " + driver.getCurrentUrl());

        } else {
            System.out.println("Link '" + linkText + "' is not present.");
        }
    }
    
  

}
