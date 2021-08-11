package ru.shop.dns.tests;

import org.junit.Test;

public class Tests01SearchAndPut extends TestsBase {

   ///////////////////////////////////////////////////////////////////////////////////////
   @Test
   public void searchAndPut() {

      app.getSearch().searchAndPut( app.getVar().getRandomItem(), 4);
      app.getSearch().searchAndPut(app.getVar().getRandomItem(), 1);
      app.getSearch().searchAndPut(app.getVar().getRandomItem(), 18);
      app.getNavigate().goToBasket();
      app.getNavigate().goToMainPage();
      //app.getVar().getRandomItem();

   }


   ///////////////////////////////////////////////////////////////////////////////////////////

}
