package ru.shop.dns.appmanager;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Variables extends HelperBase {

   public Variables(WebDriver driver) {
      super(driver);
   }


   String partOfXpathItemInSearchList = "(//div[@data-id=\"product\"])";


   public String getRandomItem() {
      List<String> list = new ArrayList<>();
      list.add("плойка");
      list.add("флешка");
      list.add("утюг");
      list.add("видеокамера");
      list.add("телефон");
      list.add("Сковорода OneTwo");
      list.add("чайник");

      Random random = new Random();
      return list.get(random.nextInt(list.size()));
   }


}
