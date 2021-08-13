package ru.shop.dns.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

   public NavigationHelper(WebDriver driver) {
      super(driver);
   }

   public void goToMainPage() {

      String xpathToMain = "//a[@id=\"header-logo\"]";
      if(driver.findElement((By.xpath(xpathToMain))).isEnabled()){
      wait(xpathToMain);
      click(By.xpath(xpathToMain));
      }
   }

   public void goToBasket() {
      String xpathToBasket = "//span[@class='cart-link__badge']";
      if(driver.findElement((By.xpath(xpathToBasket))).isEnabled()) {
         wait(xpathToBasket);
         click(By.xpath(xpathToBasket));
      }
   }
}
