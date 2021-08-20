package com.siberianhealth.ru.tests;


import com.siberianhealth.ru.appmanager.AppManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestsBase {

   public static final AppManager app = new AppManager();

   @BeforeSuite
   public void setUp() {
      app.init();
   }

   @AfterSuite
   public void tearDown() {
      app.stop();
   }

}
