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

   public String getItemName(int num) {
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
      String xpathItemPrice = "//div[@ec-product='product']["+num+"]//span[contains(@ng-bind-html, \"product.price.current\")]/span[1]";
      System.out.println(xpathItemPrice);
      return Integer.parseInt(getText(By.xpath(xpathItemPrice)));
   }

   public void checkNameItemInCart(String itemName) {
      String xpathName = "(//div[@class=\"cart-package__content\"]//div[contains(@class, \"column _name\")])[1]" +
              "//a[contains(@class, 'os-product-card__title') and contains(text(), \"" + itemName + "\")]";
      Assert.assertTrue(isElementPresent(By.xpath(xpathName)));  //проверка по названию
   }

   public void checkPriceInCart(int price) {
      String xpathItemPriceInCart = "(//div[@class=\"cart-package__content\"]//div[contains(@class, \"cart-package__item__price\")])[1]";
      int priceInCart = Integer.parseInt(getText(By.xpath(xpathItemPriceInCart)));
      Assert.assertEquals(priceInCart, price);
   }

   public void checkCountInCart(int count) {
      String xpathCount = "(//div[@class=\"cart-package__content\"]//div[contains(@class, \"column _count\")])[1]//input";
      String tmp = driver.findElement(By.xpath(xpathCount)).getAttribute("value");
      int countInCart = Integer.parseInt((tmp).replaceAll("[^0-9]", ""));
      Assert.assertEquals(countInCart, count);  //проверка по количеству
   }

   public void checkTotalCountInCart(int count) {
      String xpathTotalCountInCart ="//div[@ng-bind-html=\"userService.cart.amount\"]";
      int totalCountInCart = Integer.parseInt(getText(By.xpath(xpathTotalCountInCart)));
      Assert.assertEquals(totalCountInCart, count);

   }

   public void checkTotalPriceInCart(int price) {
      String xpathTotalPriceInCart ="//div[contains(@class, \"total-cart-block__price\")]";
      int totalPriceInCart = Integer.parseInt(getText(By.xpath(xpathTotalPriceInCart)));
      Assert.assertEquals(totalPriceInCart, price);
   }
}
