package snippet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG {

	private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1, enabled = true, timeOut = 10000)
    public void verifyLogoPresence() {
        driver.get("https://www.automationanywhere.com/");
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Automation Anywhere']"));
        assert logo.isDisplayed() : "Automation Anywhere logo is not present.";
    }

    @Test(priority = 2, enabled = true, timeOut = 20000)
    public void handleCookieConsent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement consentButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
            consentButton.click();
            System.out.println("Clicked on consent button.");
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Cookie consent banner did not appear.");
        }
    }

    @Test(priority = 3, enabled = true, timeOut = 20000)
    public void verifyAndClickLinks() {
    	 verifyAndClickLink(driver, "productsNav");
         verifyAndClickLink(driver, "solutionsNav");        
         verifyAndClickLink(driver, "resourcesNav");
         verifyAndClickLink(driver, "customersNav");      	      
         verifyAndClickLink(driver, "companyNav");
    }

    private void verifyAndClickLink(WebDriver driver, String linkText) {
        WebElement link = driver.findElement(By.xpath("//li[contains(@class, '" + linkText + "')]"));
        /* assert link.isDisplayed() : "Link '" + linkText + "' is not present.";
        link.click();
        System.out.println("Navigated to: " + driver.getCurrentUrl());*/
        
        if (link.isDisplayed()) {
            System.out.println("Link '" + linkText + "' is present.");
            link.click();
            System.out.println("Navigated to: " + driver.getCurrentUrl());

        } else {
            System.out.println("Link '" + linkText + "' is not present.");
        }
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
