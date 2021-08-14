package ru.shop.dns.tests;

import org.junit.Test;
import org.testng.Assert;

public class Test04СheckSearchHistory extends TestsBase {

   @Test
   public void test04CheckSearchHistory() {

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
      Assert.assertFalse(app.getSearch().checkSearchHistory(request[0]));

   }

}
