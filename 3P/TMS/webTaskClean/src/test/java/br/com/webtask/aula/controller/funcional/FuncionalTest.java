/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webtask.aula.controller.funcional;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author daves
 */
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FuncionalTest {

    private WebDriver driver;
    private static final String URL = "http://localhost:8090/login";

    @BeforeEach
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //driver = new ChromeDriver();
        
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        try {
            Thread.sleep(3500);            
        } catch (InterruptedException ex) {
            Logger.getLogger(FuncionalTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void TestLoginFalha() throws Exception {
        driver.get(URL);
        driver.manage().window().setSize(new Dimension(899, 866));
        //driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("abc");
        //driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("abc");
        driver.findElement(By.cssSelector(".login100-form-btn")).click();
        driver.findElement(By.cssSelector(".flex-sb-m")).click();
        assertThat(driver.findElement(By.cssSelector(".error")).getText(), is("Login ou Senha incorreta"));
    }
    
    @Test
  public void testLoginSucesso() {
    driver.get(URL);
    driver.manage().window().setSize(new Dimension(915, 860));
    //driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("123");
    //driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("123");
    driver.findElement(By.cssSelector(".login100-form-btn")).click();
    //driver.findElement(By.cssSelector("h2")).click();
    assertThat(driver.findElement(By.cssSelector("label")).getText(), is("Olá, admin!"));
  }
    
    

}
