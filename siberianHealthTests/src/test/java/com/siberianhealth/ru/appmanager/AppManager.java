package com.siberianhealth.ru.appmanager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {

   public static final String BASE_URL = "https://ru.siberianhealth.com/ru/";
   public static WebDriver driver;
   public HelperMethods searchHelper;


   public void init() {
      System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().setSize(new Dimension(1936, 1056));
      driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
      driver.manage().timeouts().pageLoadTimeout(12000, TimeUnit.MILLISECONDS);
      driver.manage().timeouts().setScriptTimeout(3000, TimeUnit.MILLISECONDS);
      searchHelper = new HelperMethods(driver);
   }

   public void stop() {

   //   driver.quit();
   }

   public HelperMethods getHelper() {
      return searchHelper;
   }


   public void getURLWebsite() {
      driver.get(BASE_URL);
   }
}
