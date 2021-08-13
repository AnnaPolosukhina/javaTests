package ru.shop.dns.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
   protected WebDriver driver;

   public HelperBase(WebDriver driver) {
      this.driver = driver;
   }

   protected void click(By locator) {
      driver.findElement(locator).click();
   }

   protected void type(By locator, String text) {
      click(locator);
      if (!driver.findElement(locator).getAttribute("value").equals(text)) {
         driver.findElement(locator).clear();
         driver.findElement(locator).sendKeys(text);
      }

   }

   protected String getAttribute(String xpath, String attribute) {
      return driver.findElement(By.xpath(xpath)).getAttribute(attribute);
   }

   protected String getText(String xpath) {
      return driver.findElement(By.xpath(xpath)).getText();
   }

   protected void wait(String xpath) {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.elementToBeClickable
              (By.xpath(xpath)));
   }

   protected void pause(int i) {
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




}
