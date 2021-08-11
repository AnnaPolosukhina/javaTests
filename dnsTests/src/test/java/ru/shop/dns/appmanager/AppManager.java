package ru.shop.dns.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AppManager {

   WebDriver driver;
   private SessionHelper sessionHelper;
   private NavigationHelper navigationHelper;
   private SearchHelper searchHelper;
   private BasketHelper basketHelper;
   private Variables var;

   public void init() {
      System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
      driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
      driver.manage().timeouts().setScriptTimeout(5000, TimeUnit.MILLISECONDS);
      WebDriverWait wait = new WebDriverWait(driver,10);
      driver.get("https://www.dns-shop.ru/");
      driver.manage().window().setSize(new Dimension(1936, 1056));
      searchHelper = new SearchHelper(driver);
      navigationHelper = new NavigationHelper(driver);
      sessionHelper = new SessionHelper(driver);
      basketHelper = new BasketHelper(driver);
      var = new Variables(driver);
   }

   public void stop() {

      //driver.quit();
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

}
