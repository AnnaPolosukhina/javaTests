package com.siberianhealth.ru.tests;


import org.testng.annotations.Test;


public class Test01CheckingItemInCart extends TestsBase {


   String itemName;     //здесь будем хранить название товара,
                        // извлекается по порядковому номеру num на странице Красота
   int num = 3;         //добавляем например 3й товар товар
   int count = 1;       //количество товара
   int price;           //здесь будем хранить цену товара


   @Test
   public void test01CheckingItemInCart() {
      app.getURLWebsite();                                    // зайти на сайт https://ru.siberianhealth.com/ru/
      app.getHelper().closePopUpWindow();                      // закрыть всплывающее информационное окошко, если выскакивает
      app.getHelper().goToBeautyCategory();                   // Зайти в категорию Красота
      itemName = app.getHelper().getItemName(num);           // Выбрать некий товар  (3й по списку в разделе красота, вернуть название)
      price = app.getHelper().getItemPrice(num);
      app.getHelper().putInCart(itemName);                    // Добавить выбранный товар в корзину
      app.getHelper().goToCart();                             // Перейти в корзину
      app.getHelper().checkNameItemInCart(itemName);        // Проверить что корзина не пустая (/присутствует выбранный товар по имени)
      app.getHelper().checkCountInCart(count);              //проверка что совпадает количество
      app.getHelper().checkPriceInCart(price);              // проверка что совпадает цена

      ////////////////  Итого в корзине
      app.getHelper().checkTotalCountInCart(count);           //проверка общего количества товаров
      app.getHelper().checkTotalPriceInCart(price);           // проверка поля "Итого к оплате"

   }




}
