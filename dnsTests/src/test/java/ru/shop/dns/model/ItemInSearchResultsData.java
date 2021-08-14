package ru.shop.dns.model;

public class ItemInSearchResultsData {
   private final String namesItem;
   private final String linksItem;
   private final int priceItem;
   private final String buttonItem;

   public ItemInSearchResultsData(String namesItem, String linksItem, int priceItem, String buttonItem) {
      this.namesItem = namesItem;
      this.linksItem = linksItem;
      this.priceItem = priceItem;
      this.buttonItem = buttonItem;
   }


   public String getNamesItem() {
      return namesItem;
   }

   public String getLinksItem() {
      return linksItem;
   }

   public int getPriceItem() {
      return priceItem;
   }

   public String getButtonItem() {
      return buttonItem;
   }

   @Override
   public String toString() {
      return "ItemData{" +
              "namesItem2='" + namesItem + '\'' +
              ", linksItem2='" + linksItem + '\'' +
              ", priceItem2=" + priceItem +
              ", buttonItem2='" + buttonItem + '\'' +
              '}';
   }
}
