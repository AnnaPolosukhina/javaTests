package ru.shop.dns.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

   public SessionHelper (WebDriver driver) {
      super(driver);
   }

   public void loginPsw(String username, String password) {
      clickToLoginButton();
      loginWithPasswordButton();
      fillLoginForm(username, password);
      submitLogin();
   }

   public void submitLogin() {
      String xpathBtnLogin = "//div[@class=\"form-entry-with-password__main-button\"]";
      click(By.xpath(xpathBtnLogin));
   }

   public void fillLoginForm(String username, String password) {
      type(By.xpath("//input[@autocomplete=\"username\"]"), username);
      type(By.xpath("//input[@autocomplete=\"current-password\"]"), password);
   }

   public void loginWithPasswordButton() {
      click(By.cssSelector(".block-other-login-methods__password-caption"));
   }

   public void clickToLoginButton() {
      click(By.xpath("//button[@data-role='login-button']"));
   }
}
