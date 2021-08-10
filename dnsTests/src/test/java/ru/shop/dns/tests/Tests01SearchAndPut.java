package ru.shop.dns.tests;

import org.junit.Test;

public class Tests01SearchAndPut extends TestsBase {

   ///////////////////////////////////////////////////////////////////////////////////////
   @Test
   public void searchAndPut() {

      app.resizeTo1936();
      app.getSearchHelper().searchAndPut("Флешка", 4);
      app.getSearchHelper().searchAndPut("Сковорода OneTwo", 1);
      app.getSearchHelper().searchAndPut("Чайник", 18);
      app.getNavigationHelper().goToBasket();
      app.assertResults();
      app.getNavigationHelper().goToMainPage();

   }


   ///////////////////////////////////////////////////////////////////////////////////////////

}
