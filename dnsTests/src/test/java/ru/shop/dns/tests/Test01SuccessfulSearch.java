package ru.shop.dns.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import sun.net.www.content.text.PlainTextInputStream;

import java.util.ArrayList;
import java.util.List;

public class Test01SuccessfulSearch extends TestsBase {

   ///////////////////////////////////////////////////////////////////////////////////////

   String request = "Процессор AMD Ryzen";

   @Test
   public void test0101CheckSuccessfulSearch() {
      app.getSearch().searchItem(request);
      Assert.assertTrue(app.getSearch().getNumberAllResults()>18);

   }

   @Test
   public void test0102CheckSuccessfulSearch() {
      Assert.assertEquals(app.getSearch().getNumberResultsInList(), 18);
   }

   @Test
   public void test0103CheckSuccessfulSearch() {

      ArrayList<String> listItemsName = app.getSearch().getAllNamesItem();
      for (String name : listItemsName) {
         Assert.assertTrue(name.contains(request));
      }

   }


   ///////////////////////////////////////////////////////////////////////////////////////////

}
