package ru.shop.dns.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

public class Test02NoSearchResults extends TestsBase {

   String request2 = "Мышь NEW203040";

   @Test
   public void test0201CheckNoSearchResults() {
      app.getSearch().searchItem(request2);
      Assert.assertTrue(app.getSearch().checkNoResults());

   }
   @Test
   public void test0202CheckNoSearchResults() {
      Assert.assertTrue(app.getSearch().checkNoResults2());

   }
   ///////////////////////////////////////////////////////////////////////////////////////////

}
