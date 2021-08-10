package ru.shop.dns.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.shop.dns.model.ItemData;

public class SearchHelper extends HelperBase {

   String partOfXpathItemInSearchList = "(//div[@data-id=\"product\"])";

   public SearchHelper(WebDriver driver) {
      super(driver);
   }

   public void putInBasket(int num) {
      ItemData data = new ItemData(getNameItem(num), getLinkToItem(num), getPrice(num), getBuyButton(num));
      click(By.xpath(data.getButtonItem2()));
      System.out.println(data);
   }

   public String getNameItem(int i) {
      String xpath = partOfXpathItemInSearchList + '[' + i + ']' + "//a[@class=\"catalog-product__name ui-link ui-link_black\"]/span";
      wait(xpath);

      String fullName = getText(xpath);
      String[] singleWords  = fullName.split("\\s");
      String threeWordName  = singleWords [0] + " " + singleWords [1] + " " + singleWords [2];

      return threeWordName ;

   }

   public String getLinkToItem(int i) {
      String xpath = partOfXpathItemInSearchList + '[' + i + ']' + "//a[@class=\"catalog-product__name ui-link ui-link_black\"]";
      return getAttribute(xpath, "href");
   }

   public int getPrice(int i) {
      String xpath = partOfXpathItemInSearchList + '[' + i + ']' + "//div[@class=\"product-buy__price\"]";
      WebElement tmpPriceItem = driver.findElement(By.xpath(xpath));
      String[] arr = tmpPriceItem.getText().split("\n");
      int price = (Integer.parseInt(arr[0].replaceAll("[^0-9]", "")));
      return price;
   }

   public String getBuyButton(int i) {
      String xpath = partOfXpathItemInSearchList + '[' + i + ']' + "//button[contains(@class, 'button-ui buy-btn button')][contains(.,'Купить')]";
      return xpath;
   }

   public void searchItem(String wantToFind) {
      String xpathToSearchString = "//*[@id='header-search']//input";
      String xpathToSearchButton = "//*[@id='header-search']//span[contains(@class, 'ui-input-search__icon_search')]";

      wait(xpathToSearchString);
      type(By.xpath(xpathToSearchString), wantToFind);
      click(By.xpath(xpathToSearchButton));

   }

   public void searchAndPut(String item, int num) {
      searchItem(item);
      putInBasket(num);
   }

}
