
package com.api.test;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FISassessment1 {
		
		
		
		

		public static void main(String[] args)
		{
			System.out.println("ASSESSMENT #1 initiated");
			
			WebDriver driver = new ChromeDriver();
			
			String url = "https://www.ebay.com/"; 
			
			driver.get(url);
			System.out.println("URL launched");
			driver.manage().window().maximize();
			
			FISassessment1 f = new FISassessment1();
			f.addToCartCheck(driver);
			System.out.println("ASSESSMENT #1 Completed");
			driver.quit();
		}


		public void addToCartCheck(WebDriver driver){
			//Search 'book'in search box
			driver.findElement(By.id("gh-ac")).sendKeys("book");
			driver.findElement(By.id("gh-btn")).click();
			
			//click on 1st book from list
			driver.findElement(By.xpath("(//ul[@class='srp-results srp-list clearfix'] //div[@class='s-item__title']/span[@aria-level='3'])[1]")).click();
			System.out.println("BOOK #1 initiated");
			
			//navigate to new tab
			ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tab.get(1));

			//validate cart has 0 books
			String cartCheck = driver.findElement(By.xpath("//li[@id='gh-minicart-hover']/div/a[1]")).getDomAttribute("aria-label");
			Assert.assertEquals(cartCheck, "Your shopping cart");
			
			//add book to cart
			driver.findElement(By.id("atcBtn_btn_1")).click();
			System.out.println("Item added to cart successfully.");
			
			//validate 1 book is added to cart
			String cartItems = driver.findElement(By.xpath("//*[@class='gh-cart-icon']/following-sibling::i[@id='gh-cart-n']")).getText();
			Assert.assertEquals(1,Integer.parseInt(cartItems));
			Assert.assertTrue(driver.findElement(By.xpath("//i[@id='gh-cart-n']")).isDisplayed());
			cartCheck = driver.findElement(By.xpath("//li[@id='gh-minicart-hover']/div/a[1]")).getDomAttribute("aria-label");
			Assert.assertEquals(cartCheck, "Your shopping cart contains 1 item");

		}
	

}