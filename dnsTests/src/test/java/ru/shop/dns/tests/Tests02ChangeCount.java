package ru.shop.dns.tests;

import org.junit.Test;

public class Tests02ChangeCount extends TestsBase {

   ///////////////////////////////////////////////////////////////////////////////////////
   @Test
   public void login() {

      app.resizeTo1936();
      app.getSearchHelper().searchItem("флешка");
      app.getSearchHelper().putInBasket(2);

      app.getNavigationHelper().goToBasket();
      app.assertResults();
      app.getNavigationHelper().goToMainPage();

   }
   ///////////////////////////////////////////////////////////////////////////////////////////

}
