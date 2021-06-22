package com.example.testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

        @Test
        public void verifyTitle(){

                WebDriverManager.chromedriver().setup();

                WebDriver driver = new ChromeDriver();

                driver.manage().window().maximize();
                driver.get("https://www.google.com");

                driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
                        .sendKeys("https://www.mercedes-benz.pt/" + Keys.ENTER);

                driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3")).click();
                driver.findElement(By.id("uc-btn-accept-banner")).click();

                String expectedTitle = "Gama de Veículos de Passageiros Mercedes-Benz";
                String actualTitle = driver.getTitle();
                Assert.assertEquals(actualTitle, expectedTitle);

                driver.close();
        }




}
