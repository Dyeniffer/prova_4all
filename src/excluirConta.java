package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class excluirConta {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://seubarriga.wcaquino.me";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testExcluirConta() throws Exception {
    driver.get("https://seubarriga.wcaquino.me/login");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("dyeni@gmail.com");
    driver.findElement(By.id("senha")).clear();
    driver.findElement(By.id("senha")).sendKeys("teste");
    driver
        .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Senha'])[1]/following::button[1]"))
        .click();
    driver.findElement(By.linkText("Contas")).click();
    driver.findElement(By.linkText("Listar")).click();
    driver
        .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Teste2'])[1]/following::span[2]"))
        .click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
