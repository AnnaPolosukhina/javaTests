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
      String xpathBeautyCategory = "//a[@href='/ru/shop/catalog/category/3/'][contains(.,'Красота')]";
      click(By.xpath(xpathBeautyCategory));

   }

   public void closePopUpWindow() {
      String xpathClose = "//button[@class=\"digi-search-highlight__close\"]";
      if (isElementPresent(By.xpath(xpathClose))) {
         click(By.xpath(xpathClose));
      }
   }

   public String selectAnyItem(int num) {
      return getText(By.xpath("//div[@ec-product=\"product\"][" + num + "]//a[@itemprop=\"name\"]"));


   }

   public void putInCart(String itemName) {
      String xpathButtonPutInCart = "//div[@class=\"products-catalog__info-container\"]/a[contains(.,'" + itemName + "')]" +
              "/parent::*/parent::*//button[@ng-click=\"addToCart()\"]";

      Actions actions = new Actions(driver);
      WebElement target = driver.findElement(By.xpath(xpathButtonPutInCart));
      actions.moveToElement(target).perform();

      click(By.xpath(xpathButtonPutInCart));

   }

   public void goToCart() {
      String xpathGoToCart = "//a[@href=\"/ru/shop/cart/\"]";
      click(By.xpath(xpathGoToCart));
   }

   public void checkBasketNotEmpty(String itemName, int i) {
      String xpath = "//div[contains(@class, 'cart-package ng-scope')]" +
              "//a[contains(@class, 'os-product-card__title') and contains(text(), \"" + itemName + "\")]";
      Assert.assertTrue(isElementPresent(By.xpath(xpath)));  //проверка по названию
      String xpath2 = "//div[@ng-bind-html=\"userService.cart.amount\"]";
      Assert.assertEquals(Integer.parseInt(driver.findElement(By.xpath(xpath2)).getText()), i);  //проверка по количеству
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

}
