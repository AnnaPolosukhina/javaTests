package ru.shop.dns.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

public class Test03CheckIconСlear extends TestsBase {

   @Test
   public void test03CheckIconClear() {
      app.getURL();
      String request = "Что же мне найти";
      app.getSearch().typeRequest(request);
      Assert.assertFalse(app.getSearch().checkIsSearchStringEmpty());
      app.getSearch().clearRequest();
      Assert.assertTrue(app.getSearch().checkIsSearchStringEmpty());




   }

}
