package com.siberianhealth.ru.data;

public class Item {
   private String name;
   private String description;
   private String imgSrc;
   private int price;
   private int id;

   public Item(String name, String description, String imgSrc, int price, int id) {
      this.name = name;
      this.description = description;
      this.imgSrc = imgSrc;
      this.price = price;
      this.id = id;
   }

   public Item() {
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getImgSrc() {
      return imgSrc;
   }

   public void setImgSrc(String imgSrc) {
      this.imgSrc = imgSrc;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   @Override
   public String toString() {
      return "Item{" +
              "name='" + name + '\'' +
              ", description='" + description + '\'' +
              ", imgSrc='" + imgSrc + '\'' +
              ", price=" + price +
              ", id=" + id +
              '}';
   }

}
