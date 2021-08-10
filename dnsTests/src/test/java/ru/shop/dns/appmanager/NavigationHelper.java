package ru.shop.dns.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
   private WebDriver driver;

   public NavigationHelper(WebDriver driver) {
      this.driver= driver;
   }

   public void goToMainPage() {
   }

   public void goToBasket() {
      String xpathToBasket = "//span[@class='cart-link__badge']";
      driver.findElement(By.xpath(xpathToBasket)).click();

   }
}
