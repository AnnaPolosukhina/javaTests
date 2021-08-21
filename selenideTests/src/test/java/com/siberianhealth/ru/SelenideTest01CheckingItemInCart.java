package com.siberianhealth.ru;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class SelenideTest01CheckingItemInCart {

   String itemName;     //здесь будем хранить название товара
   int num = 3;         //добавляем например 3й товар
   String count = "1";       //количество товара
   String price;           //здесь будем хранить цену товара

   @BeforeClass
   public static void setUp(){
      Configuration.remote = "https://ru.siberianhealth.com/ru/";
      Configuration.browserSize = "1920x1080";
      Configuration.timeout = 8000;
   }

   @Test
   void selenideTest01CheckingItemInCart(){
      open(Locators.mainURL);                                     //идем на сайт
      $(Locators.cssClosePopUpWindow).click();                    // закрыть всплывающее информационное окошко
      get(Locators.xpathBeautyCategory).click();                  // Зайти в категорию Красота
      itemName = get(Locators.xpathGetItemName(num)).getText();   // Выбрать некий товар, вернуть название
      price = get(Locators.xpathItemPrice(num)).getText();        // Запомнить цену
      get(Locators.xpathButtonPutInCart(itemName)).hover().click();     // Добавить выбранный товар в корзину
      $(Locators.cssGoToCart).click();                                  // Перейти в корзину
      //проверки в корзине
      get(Locators.xpathNameInCart).shouldHave(text(itemName));         // Проверить имя товара в листе товаров
      get(Locators.xpathCountInCart).shouldHave(value(count));          //проверка что совпадает количество
      get(Locators.xpathItemPriceInCart).shouldHave(text(price));       // проверка что совпадает цена
      //проверки - общая цена и количество
      get(Locators.xpathTotalCountInCart).shouldHave(text(count));      //проверка общего количества товаров
      $(Locators.cssTotalPriceInCart).shouldHave(text(price));          // проверка значения поля "Итого к оплате"


   }

   public SelenideElement get (String locator){
      return $(byXpath(locator));
   }
}
