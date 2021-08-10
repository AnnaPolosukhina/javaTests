package ru.shop.dns.tests;

import org.junit.After;
import org.junit.Before;
import ru.shop.dns.appmanager.AppManager;

public class TestsBase {

   protected final AppManager app = new AppManager();  //делегирование

   @Before
   public void setUp() {
      app.init();

   }

   @After
   public void tearDown() {
      app.stop();
   }

}
