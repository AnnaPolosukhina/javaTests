package ru.shop.dns.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HelperBase {
   protected WebDriver driver;

   public HelperBase(WebDriver driver) {
      this.driver = driver;
   }
   public String xpathToSearchString = "//*[@id='header-search']//input";

   public void click(By locator) {
      Assert.assertTrue(isElementPresent(locator));
      driver.findElement(locator).click();
   }

   public void type(By locator, String text) {
      click(locator);
      if (!driver.findElement(locator).getAttribute("value").equals(text)) {
         driver.findElement(locator).clear();
         driver.findElement(locator).sendKeys(text);
      }

   }

   public String getAttribute(By locator, String attribute) {
      Assert.assertTrue(isElementPresent(locator));
      return driver.findElement(locator).getAttribute(attribute);
   }

   public String getText(By locator) {
      Assert.assertTrue(isElementPresent(locator));
      return driver.findElement(locator).getText();
   }

   public WebElement findElement(By locator) {
      Assert.assertTrue(isElementPresent(locator));
      return driver.findElement(locator);
   }
   public List<WebElement> findElements(By locator) {
      Assert.assertTrue(isElementPresent(locator));
      return driver.findElements(locator);
   }

   public void wait(By locator) {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.elementToBeClickable
              (locator));
   }

   public void pause(int i) {
      try {
         Thread.sleep(i * 1000);
      } catch (InterruptedException ex) {
         Thread.currentThread().interrupt();
      }
   }

   public boolean isAlertPresent() {
      try {  driver.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e) {
         return false;
      }
   }

   public boolean isElementPresent(By locator) {
      try{
         driver.findElement(locator);
         return true;
      }  catch (NoSuchElementException exception){
         return false;
      }
   }


}
