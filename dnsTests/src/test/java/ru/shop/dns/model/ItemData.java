package ru.shop.dns.model;

public class ItemData {
   private final String namesItem2;
   private final String linksItem2;
   private final int priceItem2;
   private final String buttonItem2;

   public ItemData(String namesItem2, String linksItem2, int priceItem2, String buttonItem2) {
      this.namesItem2 = namesItem2;
      this.linksItem2 = linksItem2;
      this.priceItem2 = priceItem2;
      this.buttonItem2 = buttonItem2;
   }


   public String getNamesItem2() {
      return namesItem2;
   }

   public String getLinksItem2() {
      return linksItem2;
   }

   public int getPriceItem2() {
      return priceItem2;
   }

   public String getButtonItem2() {
      return buttonItem2;
   }

   @Override
   public String toString() {
      return "ItemData{" +
              "namesItem2='" + namesItem2 + '\'' +
              ", linksItem2='" + linksItem2 + '\'' +
              ", priceItem2=" + priceItem2 +
              ", buttonItem2='" + buttonItem2 + '\'' +
              '}';
   }
}
