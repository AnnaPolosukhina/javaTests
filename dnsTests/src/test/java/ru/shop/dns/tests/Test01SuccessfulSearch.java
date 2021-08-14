package ru.shop.dns.tests;

import org.junit.Test;
import org.testng.Assert;
import sun.net.www.content.text.PlainTextInputStream;

import java.util.ArrayList;
import java.util.List;

public class Test01SuccessfulSearch extends TestsBase {

   ///////////////////////////////////////////////////////////////////////////////////////
   @Test
   public void test01CheckSuccessfulSearch() {
      String request = "Процессор AMD Ryzen";
      app.getSearch().searchItem(request);
      Assert.assertTrue(app.getSearch().getNumberAllResults()>18);
      Assert.assertEquals(app.getSearch().getNumberResultsInList(), 18);
      ArrayList<String> listItemsName = app.getSearch().getAllNamesItem();

      for (String name : listItemsName) {
         Assert.assertTrue(name.contains(request));
      }

   }


   ///////////////////////////////////////////////////////////////////////////////////////////

}
