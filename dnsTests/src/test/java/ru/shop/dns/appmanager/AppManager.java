package ru.shop.dns.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppManager {

   WebDriver driver;
   private SessionHelper sessionHelper;
   private NavigationHelper navigationHelper;
   private SearchHelper searchHelper;

   public void init() {
      System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.get("https://www.dns-shop.ru/");
      searchHelper = new SearchHelper(driver);
      navigationHelper = new NavigationHelper(driver);
      sessionHelper = new SessionHelper(driver);
   }

   public void stop() {
      driver.quit();
   }

   public void assertResults() {
   }



   public void resizeTo1936() {
      driver.manage().window().setSize(new Dimension(1936, 1056));
   }

   public SearchHelper getSearchHelper() {
      return searchHelper;
   }

   public NavigationHelper getNavigationHelper() {
      return navigationHelper;
   }
}
