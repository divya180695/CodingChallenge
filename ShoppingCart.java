package com.java.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCart {

	public static void main(String[] args) {
		
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pillu\\Downloads\\chromedriver_win32\\chromedriver.exe");

             WebDriver driver = new ChromeDriver();

             driver.manage().window().maximize();

             //launch the application

             driver.get("https://www.saucedemo.com/");

             //enter user name

             WebElement input = driver.findElement(By.xpath("//input[@id='user-name']"));

             input.sendKeys("standard_user");

             //enter password

             WebElement paswword = driver.findElement(By.xpath("//input[@id='password']"));

             paswword.sendKeys("secret_sauce");

             //click on login button

             WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));

             loginButton.click();

             List<WebElement> prices = driver.findElements(By.xpath("//div[@class='pricebar']"));

             Iterator<WebElement> iterator = prices.iterator();

             List<Float> priceValues = new ArrayList<Float>();

             while (iterator.hasNext())

             {

                 WebElement element = iterator.next();

                 String price = element.getText();                              

                 price = price.replaceAll("[^0-9.]", "");     

                 float value = Float.parseFloat(price);

                 priceValues.add(value);

             }

     //To get the highest price product

     Float highestPriceValue = Collections.max(priceValues);

     System.out.println(highestPriceValue);

     int i = priceValues.indexOf(highestPriceValue);

     System.out.println("the index of highestprice is:"+priceValues.indexOf(highestPriceValue));

     int j= i + 1;

     //Click the Add to cart button of the highest product

     driver.findElement(By.xpath("(//button[text()='Add to cart'])[" + j+ "]")).click();
                                 
     //Click the shopping cart button

     driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();

     //verify highest price product present in the cart

     String highestPriceProduct = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();

     String highestPrice = Float.toString(highestPriceValue);

     if(highestPriceProduct.contains(highestPrice))
     {
       System.out.println("Highest price present in the cart and the value is :"+highestPrice );       
     }
    //driver.close();
}
}
