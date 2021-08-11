package ru.shop.dns.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

   public NavigationHelper(WebDriver driver) {
      super(driver);
   }

   public void goToMainPage() {
      //if(Selenium.isElementPresent((By.xpath(xpathToMain)))){
      //   return; }
      String xpathToMain = "//a[@id=\"header-logo\"]";
      wait(xpathToMain);
      click(By.xpath(xpathToMain));
   }

   public void goToBasket() {
      String xpathToBasket = "//span[@class='cart-link__badge']";
      wait(xpathToBasket);
      click(By.xpath(xpathToBasket));

   }
}
