package ru.shop.dns.tests;


import org.testng.annotations.*;
import ru.shop.dns.appmanager.AppManager;

public class TestsBase {

   protected final AppManager app = new AppManager();  //делегирование

   @BeforeClass
   public void setUp() {
      app.init();

   }

   @AfterClass
   public void tearDown() {
      app.stop();
   }

}
