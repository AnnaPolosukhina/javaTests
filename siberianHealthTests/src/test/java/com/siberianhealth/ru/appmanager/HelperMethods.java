package com.siberianhealth.ru.appmanager;

import com.siberianhealth.ru.data.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

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
      return   driver.findElements(By.xpath(Locators.xpathGetItemName)).get(num).getText();
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

   public boolean isElementPresent(WebElement we) {
      try {
         we.isDisplayed();
         return true;
      } catch (NoSuchElementException exception) {
         return false;
      }
   }

   public int getItemPrice(int num) {
      return Integer.parseInt(driver.findElements(By.xpath(Locators.xpathItemPrice)).get(num).getText());
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
      int totalPriceInCart = Integer.parseInt(getText(By.xpath(Locators.xpathTotalPriceInCart)).replaceAll("[^0-9]", ""));
      Assert.assertEquals(totalPriceInCart, price);
   }

   public List<Item> getItemsList() {
      List<Item> items = new ArrayList<Item>();
      List<WebElement> elements = driver.findElements(By.cssSelector("div.products-catalog__item"));

      for (int i = 0; i<30; i++){
         WebElement el = elements.get(i);
         String name = (el.findElement(By.xpath("div[@class=\"products-catalog__info-container\"]/a"))).getText();
         String description = null;
         if(el.findElement(By.xpath("div[@class=\"products-catalog__info-container\"]/div[@class=\"os-product-card__series ng-binding ng-scope\"]")).isDisplayed()){
            description = (el.findElement(By.xpath("div[@class=\"products-catalog__info-container\"]/div[@class=\"os-product-card__series ng-binding ng-scope\"]"))).getText();
         }
         int id = Integer.parseInt((el.findElement(By.xpath("div[@class=\"products-catalog__info-container\"]/ul/li"))).getText().replaceAll("[^0-9]", ""));
         Item item = new Item(name, description, null, 0, id);
         System.out.println(name);
//         //System.out.println("el.getAccessibleName() = "+el.getAccessibleName().toString());
//          System.out.println("el.getAriaRole() = "+el.getAriaRole());
//         System.out.println("el.getAttribute(\"class\")  = "+el.getAttribute("class"));
//         System.out.println("el.getCssValue(\"position\") = "+el.getCssValue("position"));
//         System.out.println("el.getCssValue(\"z-index\") = "+el.getCssValue("z-index"));
//
//         //System.out.println("el.getDomAttribute(\"autofocus\") = "+el.getDomAttribute("autofocus"));
//
//         //System.out.println("el.getDomProperty(\"autofocus\") = "+el.getDomProperty("autofocus"));
//         System.out.println("el.getLocation().toString() = "+el.getLocation().toString());
//         System.out.println("el.getRect().toString() = "+el.getRect().toString());
//         System.out.println("el.getSize().toString() = "+el.getSize().toString());
//         System.out.println("el.getTagName() = "+el.getTagName());
//         System.out.println("el.getText() = "+el.getText());
//         System.out.println("el.toString() = "+el.toString());

         items.add(item);

      }

      for (Item item : items) {
         System.out.println(item);

      }


      return items;
   }
}
