package ru.shop.dns.tests;

import org.junit.Test;
import org.testng.Assert;

public class Test03CheckIconСlear extends TestsBase {

   @Test
   public void test03CheckIconСlear() {

      String request = "Процессор AMD Ryzen";
      app.getSearch().typeRequest(request);
      app.getSearch().clearRequest();
      Assert.assertTrue(app.getSearch().checkIsSearchStringEmpty());




   }

}
