package com.inhahara.tests.stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
    private WebDriver driver;

    @Before
    public void initiate() {
        // Open browser before each Scenario
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        // Close browser after each Scenario
        //driver.close();
    }
    
    @Given("I go to the {string} login page")
    public void i_go_to_the_login_page(final String loginUrl) {
        driver.get(loginUrl);
        waitSeconds(3);
    }
    
    @When("I have accepted cookies by click {string}")
    public void i_have_accepted_cookies_by_click(final String cookiesElementXpath) {
        clickElement(cookiesElementXpath, false);
    }
    
    @When("I have accepted terms and conditions by check {string}")
    public void i_have_accepted_terms_and_conditions_by_check(final String tcElementXpath) {
        clickElement(tcElementXpath, true);
    }
    
    @When("I have choose location by click {string}")
    public void i_have_choose_location_by_click(final String locationElementXpath) {
        waitSeconds(2);
        clickElement(locationElementXpath, false);
    }
    
    @When("I have clicked {string}")
    public void i_have_clicked(final String elementXpath) {
        waitSeconds(2);
        clickElement(elementXpath, true);
    }
    
    @When("I have input username {string} to field {string}")
    public void i_have_input_username_to_field(final String username, final String fieldXpath) {
        inputElement(username, fieldXpath);
    }

    @When("I have input password {string} to field {string}")
    public void i_have_input_password_to_field(final String password, final String fieldXpath) {
        inputElement(password, fieldXpath);
    }
    
    @When("I have input {string} to field {string}")
    public void i_have_input_to_field(final String value, final String fieldXpath) {
        inputElement(value, fieldXpath);
    }
    
    @When("I have login by click {string}")
    public void i_have_login_by_click(final String elementXpath) { 
        clickElement(elementXpath, true);
        waitSeconds(3);
    }
    
    @When("I have clicked cancel on alert")
    public void i_have_clicked_cancel_on_alert() { 
        waitSeconds(3);
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            System.out.println("Alert is not found.");
        }
    }

    @Then("The page {string} is opened")
    public void the_page_is_opened(final String url) {
        waitSeconds(3);
        final String browserUrl = driver.getCurrentUrl(); 
        if (!browserUrl.equals(url)) { 
            Assert.assertTrue("This page('" + browserUrl + "') is not '" + url + "'.", false); 
        }
    }
    
    @Then("The opened page starts by {string}")
    public void the_opened_page_starts_by(final String url) {
        waitSeconds(3);
        final String browserUrl = driver.getCurrentUrl(); 
        if (!browserUrl.startsWith(url)) { 
            Assert.assertTrue("This page('" + browserUrl + "') is not '" + url + "'.", false); 
        }
    }
    
    @Then("I see my account element {string}")
    public void i_see_my_account(final String myAccountElementXpath) {
        waitSeconds(5);
        elementExists(myAccountElementXpath);
    }
    
    @Then("I see logout element {string}")
    public void i_see_logout(final String logoutElementXpath) {
        waitSeconds(2);
        elementExists(logoutElementXpath);
    }
        
    private void inputElement(final String value, final String elementXpath) {
        final WebElement element = findElementSafety(elementXpath); 
        if (element != null) {
            element.sendKeys(value);
        } else {
            Assert.assertTrue("Element('" + elementXpath + "') is not found.", false);
        }
        waitOneSecond();
    }
    
    private void clickElement(final String elementXpath, final boolean assertIfNotFound) {
        final WebElement element = findElementSafety(elementXpath); 
        if (element != null) {
            element.click();
        } else if (assertIfNotFound) {
            Assert.assertTrue("Element('" + elementXpath + "') is not found.", false);
        }
    }
    
    private WebElement findElementSafety(final String elementXpath) {
        try {
            return driver.findElement(By.xpath(elementXpath));
        } catch (NoSuchElementException e) {
            System.out.println("'" + elementXpath + "' is not found.");
            return null;
        }
    }
    
    private void elementExists(final String elementXpath) {
        final WebElement element = findElementSafety(elementXpath); 
        Assert.assertTrue(element != null);
    }
    
    private void waitOneSecond() {
        waitSeconds(1);
    }
    
    private void waitSeconds(final int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
}
