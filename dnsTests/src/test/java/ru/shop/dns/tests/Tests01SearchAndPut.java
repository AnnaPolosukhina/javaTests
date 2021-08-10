package ru.shop.dns.tests;

import org.junit.Test;

public class Tests01SearchAndPut extends TestsBase {

   ///////////////////////////////////////////////////////////////////////////////////////
   @Test
   public void login() {

      app.resizeTo1936();
      app.getSearchHelper().searchItem("флешка");
      app.getSearchHelper().putInBasket(5);
      app.getSearchHelper().searchItem("Сковорода OneTwo");
      app.getSearchHelper().putInBasket(1);
      app.getSearchHelper().searchItem("Чайник");
      app.getSearchHelper().putInBasket(18);
      app.getNavigationHelper().goToBasket();
      app.assertResults();
      app.getNavigationHelper().goToMainPage();

   }
   ///////////////////////////////////////////////////////////////////////////////////////////

}
