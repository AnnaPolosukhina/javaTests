package ru.shop.dns.tests;

import org.junit.Test;
import org.testng.Assert;
import sun.net.www.content.text.PlainTextInputStream;

import java.util.ArrayList;
import java.util.List;

public class Test01SuccessfulSearch extends TestsBase {

   ///////////////////////////////////////////////////////////////////////////////////////

   String request = "Процессор AMD Ryzen";

   @Test
   public void test001CheckSuccessfulSearch() {
      app.getSearch().searchItem(request);
      Assert.assertTrue(app.getSearch().getNumberAllResults()>18);

   }

   @Test
   public void test002CheckSuccessfulSearch() {
      app.getSearch().searchItem(request);
      Assert.assertEquals(app.getSearch().getNumberResultsInList(), 18);
   }

   @Test
   public void test003CheckSuccessfulSearch() {
      app.getSearch().searchItem(request);

      ArrayList<String> listItemsName = app.getSearch().getAllNamesItem();
      for (String name : listItemsName) {
         Assert.assertTrue(name.contains(request));
      }

   }


   ///////////////////////////////////////////////////////////////////////////////////////////

}
