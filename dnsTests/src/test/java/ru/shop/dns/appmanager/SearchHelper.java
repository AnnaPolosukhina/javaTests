package ru.shop.dns.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.shop.dns.model.ItemInSearchResultsData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SearchHelper extends HelperBase {

   String partOfXpathItemInSearchList = "(//div[@data-id=\"product\"])";

   public SearchHelper(WebDriver driver) {
      super(driver);
   }

   public void putInBasket(int num) {
      ItemInSearchResultsData data = new ItemInSearchResultsData(getNameItem(num), getLinkToItem(num), getPrice(num), getBuyButton(num));
      click(By.xpath(data.getButtonItem()));
   }

   public String getNameItem(int i) {
      String xpath = partOfXpathItemInSearchList + '[' + i + ']' + "//a[@class=\"catalog-product__name ui-link ui-link_black\"]/span";
      String fullName = getText(By.xpath(xpath));
      String[] singleWords = fullName.split("\\s");
      String threeWordName = singleWords[0] + " " + singleWords[1] + " " + singleWords[2];

      return threeWordName;

   }

   public String getLinkToItem(int i) {
      String xpath = partOfXpathItemInSearchList + '[' + i + ']' + "//a[@class=\"catalog-product__name ui-link ui-link_black\"]";
      return getAttribute(By.xpath(xpath), "href");
   }

   public int getPrice(int i) {
      String xpath = partOfXpathItemInSearchList + '[' + i + ']' + "//div[contains(@class, \"product-buy__price\")]";
      WebElement tmpPriceItem = findElement(By.xpath(xpath));
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

      type(By.xpath(xpathToSearchString), wantToFind);
      click(By.xpath(xpathToSearchButton));

   }

   public void searchAndPut(String item, int num) {
      searchItem(item);
      putInBasket(num);
   }

   public int getNumberAllResults() {
      String xpathToNumberAllResults = "//div[contains(@class,'products-page__title')]//span[@class='products-count']";
      WebElement element = findElement(By.xpath(xpathToNumberAllResults));
      String str = element.getText();
      int num = (Integer.parseInt(str.replaceAll("[^0-9]", "")));
      return num;
   }


   public int getNumberResultsInList() {
      return getAllNamesItem().size();
   }

   public void checkResultsName(String request) {
   }

   public boolean checkNoResults() {

      String xpathCheckNoResults = "//h4[contains(@class,'empty-search-results')]";
      Assert.assertTrue(isElementPresent(By.xpath(xpathCheckNoResults)));
      WebElement element = findElement(By.xpath(xpathCheckNoResults));
      String str = element.getText();
      if (str.contains("Странно, но ничего нет")) {
         return true;
      }
      return false;
   }

   public boolean checkNoResults2() {

      String xpathCheckNoResults = "//h5[contains(@class, 'empty-search-results')]";
      Assert.assertTrue(isElementPresent(By.xpath(xpathCheckNoResults)));
      WebElement element = findElement(By.xpath(xpathCheckNoResults));
      String str = element.getText();
      if (str.contains("К сожалению, по вашему запросу ничего не найдено")) {
         return true;
      }
      return false;
   }

   public void typeRequest(String request) {
      type(By.xpath(xpathToSearchString), request);
   }

   public void clearRequest() {
      String xpath = "//span[contains(@class,'clear-visible')]";
      click(By.xpath(xpath));

   }

   public boolean checkIsSearchStringEmpty() {
      return findElement(By.xpath(xpathToSearchString)).getAttribute("value").equals("");
   }

   public boolean checkSearchHistory(String[] requestReverse) {

      findElement(By.xpath(xpathToSearchString)).click();
      findElement(By.xpath(xpathToSearchString)).clear();
      String xpath = "//div[@class=\"presearch__suggests\"]//a[(contains(@class, \"suggest_history\")) " +
              "and not(contains(@class,'suggests_hidden'))]";

      String[] result = new String[5];
      for (int i=0; i<requestReverse.length; i++){
         String str = findElement(By.xpath(xpath+"["+(i+1)+"]")).getText();
         result[i] = str;
      }

      return Arrays.equals(requestReverse, result);

   }

   public boolean checkStringIsNotInHistory(String requestReverse) {
      String xpath = "//div[@class=\"presearch__suggests\"]//a[(contains(@class, \"suggest_history\")) " +
              "and not(contains(@class,'suggests_hidden'))]";
      String[] result = {};
      for (int i = 0; i < 5; i++) {

         if (isElementPresent(By.xpath(xpath + "[" + (i+1) + "]"))) {
            String str = (findElement(By.xpath(xpath + "[" + (i+1) + "]"))).getText();
            if (requestReverse.equals(str)) return false;
         }

      }
      return true;
   }

   public ArrayList<String> getAllNamesItem() {
      String link = partOfXpathItemInSearchList + "//a[@class=\"catalog-product__name ui-link ui-link_black\"]/span";
      List<WebElement> elements = findElements(By.xpath(link));
      ArrayList<String> namesItem = new ArrayList<String>();
      for (WebElement element : elements) {
         namesItem.add(element.getText());
      }
      return namesItem;
   }


}
