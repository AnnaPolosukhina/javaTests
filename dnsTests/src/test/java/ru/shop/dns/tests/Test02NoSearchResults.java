package ru.shop.dns.tests;

import org.junit.Test;
import org.testng.Assert;

public class Test02NoSearchResults extends TestsBase {

   ///////////////////////////////////////////////////////////////////////////////////////
   @Test
   public void test02CheckNoSearchResults() {

      String request = "Процессор AMD Ryzen";
      app.getSearch().searchItem(request);
      Assert.assertTrue(app.getSearch().checkNoResults());


      

   }
   ///////////////////////////////////////////////////////////////////////////////////////////

}
