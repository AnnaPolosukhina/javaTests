package com.siberianhealth.ru.tests;


import org.testng.annotations.Test;


public class Test01CheckingItemInCart extends TestsBase {


   String itemName;   //что буду искать и добавлять в корзину

   @Test
   public void test01CheckingItemInCart() {
      app.getURLWebsite();                                  // зайти на сайт https://ru.siberianhealth.com/ru/
      app.getHelper().goToBeautyCategory();                 // Зайти в категорию Красота
      itemName = app.getHelper().selectAnyItem(3);     // Выбрать некий товар  (3й по списку в разделе красота, вернуть название)
      app.getHelper().putInCart(itemName);                  // Добавить выбранный товар в корзину
      app.getHelper().goToCart();                           // Перейти в корзину
      app.getHelper().checkBasketNotEmpty(itemName, 1);        // Проверить что корзина не пустая (/присутствует выбранный товар в количестве 1 единица)


   }





}
