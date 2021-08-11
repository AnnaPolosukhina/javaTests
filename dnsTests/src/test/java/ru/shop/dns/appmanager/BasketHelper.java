package ru.shop.dns.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasketHelper extends HelperBase {

   public BasketHelper(WebDriver driver) {
      super(driver);
   }

   public void changeCount() {
      String xpathPlus = "//button[contains(@class, \"button_plus\")]";
      String xpathMinus = "//button[contains(@class, \"button_minus\")]";
      String xpathCount = "//div[@class='total-amount__count'][contains(.,'Итого')]";
      wait(xpathPlus);
      click(By.xpath(xpathPlus));
      pause(2);
      Assert.assertEquals(getText(xpathCount),"Итого: 2 товара");
      click(By.xpath(xpathMinus));
      pause(2);
      Assert.assertEquals(getText(xpathCount),"Итого: 1 товар");

   }

   public void checkChangeCountItem() {
   }

   public void checkChangesPrice() {
   }
}

