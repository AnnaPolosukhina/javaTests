package ru.shop.dns.tests;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ru.shop.dns.appmanager.AppManager;

public class TestsBase {

   protected final AppManager app = new AppManager();  //делегирование

   @BeforeSuite
   public void setUp() {
      app.init();

   }

   @AfterSuite
   public void tearDown() {
      app.stop();
   }

}
