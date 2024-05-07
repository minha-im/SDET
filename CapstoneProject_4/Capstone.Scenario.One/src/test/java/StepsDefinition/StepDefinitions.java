package StepsDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestRunner.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions extends BaseTest{
    static WebDriver driver;

    @Given("^User navigates to the homepage$")
    public void navigateToHomePage() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
    }

    @Then("^Page title should be \"([^\"]*)\"$")
    public void verifyTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Then("^Page should display text \"([^\"]*)\"$")
    public void verifyText(String expectedText) {
        WebElement textElement = driver.findElement(By.tagName("h3"));
        String actualText = textElement.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Then("^User clicks on A/B Testing link$")
    public void clickABTestingLink() {
        WebElement abTestingLink = driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]"));
        abTestingLink.click();
    }

    @Then("^User clicks on dropdown link$")
    public void clickDropdownLink() {
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        dropdownLink.click();
    }

    @Then("^User selects Option1 from dropdown$")
    public void selectOption1FromDropdown() {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.findElement(By.xpath("//option[contains(text(),'Option 1')]")).click();
    }

    @Then("^Option1 should be selected$")
    public void verifyOption1Selected() {
        WebElement selectedOption = driver.findElement(By.xpath("//option[contains(text(),'Option 1')][@selected='selected']"));
        Assert.assertNotNull(selectedOption);
    }

    @Then("^User clicks on Frames link$")
    public void clickFramesLink() {
        WebElement framesLink = driver.findElement(By.linkText("Frames"));
        framesLink.click();
    }

    @Then("^Nested Frames link should be present$")
    public void verifyNestedFramesLink() {
        WebElement nestedFramesLink = driver.findElement(By.linkText("Nested Frames"));
        Assert.assertNotNull(nestedFramesLink);
    }

    @Then("^iFrame link should be present$")
    public void verifyIFrameLink() {
        WebElement iFrameLink = driver.findElement(By.linkText("iFrame"));
        Assert.assertNotNull(iFrameLink);
    }

    @Then("^User closes the browser$")
    public void closeBrowser() {
        driver.quit();
    }
}
