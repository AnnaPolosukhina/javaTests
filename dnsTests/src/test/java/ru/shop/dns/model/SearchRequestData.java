package ru.shop.dns.model;

public class SearchRequestData {
   private final String request;

   public SearchRequestData(String request) {
      this.request = request;
   }

   public String getRequest() {
      return request;
   }

   @Override
   public String toString() {
      return "SearchRequestData{" +
              "request='" + request + '\'' +
              '}';
   }

}
