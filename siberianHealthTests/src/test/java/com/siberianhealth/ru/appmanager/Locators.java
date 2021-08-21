package com.siberianhealth.ru.appmanager;

public class Locators {
   //каталог Красота
   public static String xpathBeautyCategory = "//a[@href='/ru/shop/catalog/category/3/'][contains(.,'Красота')]";
   //закрыть инфо окошко
   public static String xpathClosePopUpWindow = "//button[@class=\"digi-search-highlight__close\"]";
   //положить в корзину по названию товара
   public static String xpathButtonPutInCart(String itemName){
      return  "//div[@class=\"products-catalog__info-container\"]/a[contains(.,'" + itemName + "')]" +
              "/parent::*/parent::*//button[@ng-click=\"addToCart()\"]";
   }
   //перейти в корзину
   public static String xpathGoToCart = "//a[@href=\"/ru/shop/cart/\"]";
   //цена на товар в каталоге Красота
   public static String xpathItemPrice(int num){
      return "//div[@ec-product='product']["+num+"]//span[contains(@ng-bind-html, \"product.price.current\")]/span[1]";  }

   //проверка имени товара в корзине
   public static String xpathName(String itemName){
      return  "(//div[@class=\"cart-package__content\"]//div[contains(@class, \"column _name\")])[1]" +
           "//a[contains(@class, 'os-product-card__title') and contains(text(), \"" + itemName + "\")]";   }
   //цена товара в корзине
   public static String xpathItemPriceInCart = "(//div[@class=\"cart-package__content\"]//div[contains(@class, \"cart-package__item__price\")])[1]";
   //количество товара в корзине
   public static String xpathCount = "(//div[@class=\"cart-package__content\"]//div[contains(@class, \"column _count\")])[1]//input";
   //количество всех товаров в корзине
   public static String xpathTotalCountInCart ="//div[@ng-bind-html=\"userService.cart.amount\"]";
   //общая цена за все товары в корзине
   public static String xpathTotalPriceInCart ="//div[contains(@class, \"total-cart-block__price\")]";
   //название товара в каталоге красота (по номеру num)
   public static String xpathGetItemName (int num){
      return "//div[@ec-product=\"product\"][" + num + "]//a[@itemprop=\"name\"]";
   }

}
