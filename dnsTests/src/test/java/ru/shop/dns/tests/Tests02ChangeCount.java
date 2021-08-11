package ru.shop.dns.tests;

import org.junit.Test;

public class Tests02ChangeCount extends TestsBase {

   ///////////////////////////////////////////////////////////////////////////////////////
   @Test
   public void changeCount() {

      app.getSearch().searchAndPut(app.getVar().surname(), 2);
      app.getNavigate().goToBasket();
      app.getBasket().changeCount();
      app.getBasket().checkChangeCountItem();
      app.getBasket().checkChangesPrice();

      

   }
   ///////////////////////////////////////////////////////////////////////////////////////////

}
