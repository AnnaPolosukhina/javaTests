package ru.shop.dns.appmanager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {

   public static final String BASE_URL = "https://www.dns-shop.ru";
   public static WebDriver driver;
   public SessionHelper sessionHelper;
   public NavigationHelper navigationHelper;
   public SearchHelper searchHelper;
   public BasketHelper basketHelper;
   public Variables var;

   public void init() {
      System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(13000, TimeUnit.MILLISECONDS);
      driver.manage().timeouts().pageLoadTimeout(12000, TimeUnit.MILLISECONDS);
      driver.manage().timeouts().setScriptTimeout(13000, TimeUnit.MILLISECONDS);
      driver.manage().window().setSize(new Dimension(1936, 1056));
      searchHelper = new SearchHelper(driver);
      navigationHelper = new NavigationHelper(driver);
      sessionHelper = new SessionHelper(driver);
      basketHelper = new BasketHelper(driver);
      var = new Variables(driver);
   }

   public void stop() {

      driver.quit();
   }

   public SearchHelper getSearch() {
      return searchHelper;
   }

   public NavigationHelper getNavigate() {
      return navigationHelper;
   }

   public SessionHelper getSession() {
      return sessionHelper;
   }

   public BasketHelper getBasket() {
      return basketHelper;
   }

   public Variables getVar() {
      return var;
   }

   public void getURL() {
      driver.get(BASE_URL);
   }
}
