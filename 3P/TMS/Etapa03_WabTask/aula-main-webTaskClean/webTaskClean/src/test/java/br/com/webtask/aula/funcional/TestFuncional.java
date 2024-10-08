package br.com.webtask.aula.funcional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;
import java.util.Map;

public class TestLoginIncorretoTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  private JavascriptExecutor js;

  @BeforeEach
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver.exe");

    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<>();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testLoginIncorreto() {
    driver.get("http://localhost:8080/login");
    driver.manage().window().setSize(new Dimension(1366, 728));
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("kkk");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("kkk");
    driver.findElement(By.cssSelector(".login100-form-btn")).click();
    driver.findElement(By.cssSelector(".wrap-login100")).click();
    assertThat(driver.findElement(By.cssSelector(".error")).getText(), is("Login ou Senha incorreta"));
  }
}