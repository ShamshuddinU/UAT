package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import com.rabit.testgen.util.RecorderUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.io.File;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UATOpportunityTest {
private EventFiringWebDriver driver;
  private RecorderUtil recorderObj= new RecorderUtil();
  private String title;
private String assertionData;
private String[]  testData = new String [20];

  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
String path= this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + File.separator;
	String package1 = this.getClass().getPackage().getName();
	String [] parts= package1.split("\\.");
	for (int i = 0; i < parts.length; i++) {
	String part = parts[i];
	if(parts.length == i) {
	path = path + part;
	} else {
	path = path + part + File.separator;
	}
	}
	driver= recorderObj.Browser("autorabit.com-VhPD4x","UATOpportunityTest",path) ;
	recorderObj.setDriver(driver);
	driver.manage().window().maximize();

    baseUrl = "https://login.salesforce.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUATOpportunity() throws Exception {

	 try{
	Actions action = new Actions(driver);
	    driver.findElement(By.xpath("//input[@id='Login']")).click();
	
	    driver.findElement(By.xpath("//a/img")).click();
	
	    driver.findElement(By.xpath("//tr[8]/td[2]/a")).click();
	
	    driver.findElement(By.xpath("//input[@name='new']")).click();
	
	    driver.findElement(By.xpath("//input[@id='opp3']")).sendKeys("Test-UAT1");
	    driver.findElement(By.xpath("//input[@id='opp9']")).click();
	
	    driver.findElement(By.xpath("//input[@id='opp9']")).sendKeys("2/28/2017");
	    driver.findElement(By.xpath("//span/a/img")).click();
	
recorderObj.switchFrame("searchFrame");
	    driver.findElement(By.xpath("//input[@id='lksrch']")).sendKeys("Test");
    driver.findElement(By.xpath("//input[@name='go']")).click();
recorderObj.switchFrame("resultsFrame");
    driver.findElement(By.xpath("//a[@onclick=\"top.window.opener.lookupPick('editPage','opp4_lkid','opp4','','0012800000chHy3','Test','null','')\"]")).click();
recorderObj.switchMainWindow();
	    driver.findElement(By.xpath("//input[@id='opp4']")).sendKeys("Test");
	    new Select(driver.findElement(By.xpath("//select[@id='opp11']"))).selectByVisibleText("Prospecting");recorderObj.waitSeconds(2);
	
	    driver.findElement(By.xpath("//input[@name='save']")).click();
	
  }

	catch (AssertionError e){
	recorderObj.screenshot(e);
	if(e.getMessage().contains("\n")){
		fail(e.getMessage().substring(0, e.getMessage().indexOf("\n")));
		}
		else fail(e.getMessage());
	}
	catch (Exception e){
	recorderObj.screenshot(e);
	if(e.getMessage().contains("\n")){
		fail(e.getMessage().substring(0, e.getMessage().indexOf("\n")));
		}
		else fail(e.getMessage());
	}
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
