package ru.shop.dns.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

public class Test03CheckIconСlear extends TestsBase {

   @Test
   public void test03CheckIconСlear() {

      String request = "Что же мне найти";
      app.getSearch().typeRequest(request);
      app.getSearch().clearRequest();
      Assert.assertTrue(app.getSearch().checkIsSearchStringEmpty());




   }

}
