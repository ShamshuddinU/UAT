package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UATOpportunityTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://login.salesforce.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUATOpportunity() throws Exception {
    driver.get(baseUrl + "/")
    driver.findElement(By.xpath("//input[@id='username']")).clear();
    driver.findElement(By.xpath("//input[@id='username']")).sendKeys("shamshuddink9@gmail.com");
    driver.findElement(By.xpath("//input[@id='password']")).clear();
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Rabit@345");
    driver.findElement(By.xpath("//input[@id='Login']")).click();
    driver.findElement(By.xpath("//a/img")).click();
    driver.findElement(By.xpath("//tr[8]/td[2]/a")).click();
    driver.findElement(By.xpath("//input[@name='new']")).click();
    driver.findElement(By.xpath("//input[@id='opp3']")).clear();
    driver.findElement(By.xpath("//input[@id='opp3']")).sendKeys("Test-UAT");
    driver.findElement(By.xpath("//input[@id='opp3']")).clear();
    driver.findElement(By.xpath("//input[@id='opp3']")).sendKeys("Test-UAT2");
    driver.findElement(By.xpath("//input[@id='opp9']")).click();
    driver.findElement(By.xpath("//input[@id='opp9']")).click();
    driver.findElement(By.xpath("//input[@id='opp9']")).clear();
    driver.findElement(By.xpath("//input[@id='opp9']")).sendKeys("2/28/2017");
    driver.findElement(By.xpath("//span/a/img")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | lookup | 30000]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=searchFrame | ]]
    driver.findElement(By.xpath("//input[@id='lksrch']")).clear();
    driver.findElement(By.xpath("//input[@id='lksrch']")).sendKeys("Test");
    driver.findElement(By.xpath("//input[@name='go']")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=resultsFrame | ]]
    driver.findElement(By.xpath("//a[@onclick=\"top.window.opener.lookupPick('editPage','opp4_lkid','opp4','','0012800000chHy3','Test','null','')\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.xpath("//input[@id='opp4']")).clear();
    driver.findElement(By.xpath("//input[@id='opp4']")).sendKeys("Test");
    new Select(driver.findElement(By.xpath("//select[@id='opp11']"))).selectByVisibleText("Qualification");
    driver.findElement(By.xpath("//input[@name='save']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
