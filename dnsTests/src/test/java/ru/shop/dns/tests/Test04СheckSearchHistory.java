package ru.shop.dns.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

public class Test04СheckSearchHistory extends TestsBase {

   @Test
   public void test04CheckSearchHistory() {

      app.getURL();

      String[] request = {
              "Колонки",
              "Компьютер",
              "Микроволновка",
              "Материнская плата",
              "Робот-пылесос",
              "Зеркальная камера Canon"
      };

      String[] requestReverse = {request[5],request[4],request[3],request[2],request[1]};

      for(int i=0; i<request.length;i++){
         app.getSearch().searchItem(request[i]);
      }

      Assert.assertTrue(app.getSearch().checkSearchHistory(requestReverse));
      Assert.assertTrue(app.getSearch().checkStringIsNotInHistory(request[0]));

   }

}
