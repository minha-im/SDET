package snippet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

	public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.automationanywhere.com/");
        driver.manage().window().maximize();

        WebElement logo = driver.findElement(By.xpath("//img[@alt='Automation Anywhere']"));
        if (logo.isDisplayed()) {
            System.out.println("Automation Anywhere logo is present.");
        } else {
            System.out.println("Automation Anywhere logo is not present.");
        }

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        
        WebElement requestDemoButton = driver.findElement(By.xpath("//a[@title='Request demo']"));
        if (requestDemoButton.isDisplayed() && requestDemoButton.isEnabled()) {
            System.out.println("Request Demo button is present and clickable.");
            requestDemoButton.click();
            
        } else {
            System.out.println("Request Demo button is not present or not clickable.");
        }

        driver.quit();
    }

}
