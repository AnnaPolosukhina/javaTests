package com.siberianhealth.ru.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

public class HelperMethods {
   protected WebDriver driver;

   public HelperMethods(WebDriver driver) {
      this.driver = driver;
   }

   public void goToBeautyCategory() {
      click(By.xpath(Locators.xpathBeautyCategory));
   }

   public void closePopUpWindow() {
      if (isElementPresent(By.xpath(Locators.xpathClosePopUpWindow))) {
         click(By.xpath(Locators.xpathClosePopUpWindow));
      }
   }

   public String getItemName(int num) {
      return getText(By.xpath(Locators.xpathGetItemName(num)));
   }

   public void putInCart(String itemName) {
      Actions actions = new Actions(driver);
      WebElement target = driver.findElement(By.xpath(Locators.xpathButtonPutInCart(itemName)));
      actions.moveToElement(target).perform();
      click(By.xpath(Locators.xpathButtonPutInCart(itemName)));
   }

   public void goToCart() {
      click(By.xpath(Locators.xpathGoToCart));
   }

   public void click(By locator) {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.elementToBeClickable
              (locator));
      Assert.assertTrue(isElementPresent(locator));
      driver.findElement(locator).click();
   }

   public String getText(By locator) {
      Assert.assertTrue(isElementPresent(locator));
      return driver.findElement(locator).getText();
   }

   public boolean isElementPresent(By locator) {
      try {
         driver.findElement(locator);
         return true;
      } catch (NoSuchElementException exception) {
         return false;
      }
   }

   public int getItemPrice(int num) {
      System.out.println(Locators.xpathItemPrice(num));
      return Integer.parseInt(getText(By.xpath(Locators.xpathItemPrice(num))));
   }

   public void checkNameItemInCart(String itemName) {
      Assert.assertTrue(isElementPresent(By.xpath(Locators.xpathName(itemName))));  //проверка по названию
   }

   public void checkPriceInCart(int price) {
      String str = getText(By.xpath(Locators.xpathItemPriceInCart)).replaceAll("[^0-9]", "");
      int priceInCart = Integer.parseInt(str);
      System.out.println(priceInCart +" "+price);
      Assert.assertEquals(priceInCart, price);
   }

   public void checkCountInCart(int count) {
      String tmp = driver.findElement(By.xpath(Locators.xpathCount)).getAttribute("value");
      int countInCart = Integer.parseInt(tmp);
      Assert.assertEquals(countInCart, count);  //проверка по количеству
   }

   public void checkTotalCountInCart(int count) {
      int totalCountInCart = Integer.parseInt(getText(By.xpath(Locators.xpathTotalCountInCart)));
      Assert.assertEquals(totalCountInCart, count);

   }

   public void checkTotalPriceInCart(int price) {
      int totalPriceInCart = Integer.parseInt(getText(By.xpath(Locators.xpathTotalPriceInCart)));
      Assert.assertEquals(totalPriceInCart, price);
   }
}
