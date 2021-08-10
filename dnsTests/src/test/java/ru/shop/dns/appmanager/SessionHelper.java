package ru.shop.dns.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {


   private WebDriver driver;

   public SessionHelper(WebDriver driver) {
      this.driver = driver;
   }

   public void loginPsw(String username, String password) {
      clickToLoginButton();
      loginWithPasswordButton();
      fillLoginForm(username, password);
      submitLogin();
   }

   public void submitLogin() {
      driver.findElement(By.xpath("//div[@class=\"form-entry-with-password__main-button\"]")).click();
   }

   public void fillLoginForm(String username, String password) {
      driver.findElement(By.xpath("//input[@autocomplete=\"username\"]")).sendKeys(username);
      driver.findElement(By.xpath("//input[@autocomplete=\"current-password\"]")).sendKeys(password);
   }

   public void loginWithPasswordButton() {
      driver.findElement(By.cssSelector(".block-other-login-methods__password-caption")).click();
   }

   public void clickToLoginButton() {
      driver.findElement(By.xpath("//button[@data-role='login-button']")).click();
   }
}
