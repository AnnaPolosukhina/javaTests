package ru.shop.dns.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
   private WebDriver driver;

   public NavigationHelper(WebDriver driver) {
      super(driver);
   }

   public void goToMainPage() {
   }

   public void goToBasket() {
      String xpathToBasket = "//span[@class='cart-link__badge']";
      click(By.xpath(xpathToBasket));

   }
}
