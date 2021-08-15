package ru.shop.dns.tests;


import org.testng.annotations.*;
import ru.shop.dns.appmanager.AppManager;

public class TestsBase {

   public static final AppManager app = new AppManager();  //делегирование

   @BeforeSuite
   public void setUp() {
      app.init();
   }

   @AfterSuite
   public void tearDown() {
      app.stop();
   }

}
