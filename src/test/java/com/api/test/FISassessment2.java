package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class FISassessment2 {
	
	
	@Test
	 void apiTest() {
		
		Response response = RestAssured.when().get("https://api.coindesk.com/v1/bpi/currentprice.json");
		System.out.println("Response Code : "+ response.getStatusCode());
		JsonPath jp = response.jsonPath();
		String json = response.asString();
		
		Assert.assertEquals(jp.get("bpi.GBP.description"), "British Pound Sterling", "Correct value");
		System.out.println(jp.getString("bpi.USD.code"));
		Assert.assertEquals(jp.getString("bpi.USD.code"), "USD", "Correct value");
		Assert.assertEquals(jp.getString("bpi.GBP.code"), "GBP", "Correct value");
		Assert.assertEquals(jp.getString("bpi.EUR.code"), "EUR", "Correct value");
		
		 if(response.path("bpi.USD.code") == null){
	            System.out.println("USD does not exist");
	        }
		 else{
	            System.out.println("Value does  exist : " + response.path("bpi.USD.code").toString());
	        }
		 if(response.path("bpi.GBP.code") == null){
	            System.out.println("GBP does not exist ");
	        }
		 else{
	            System.out.println("Value does  exist : " + response.path("bpi.GBP.code").toString());
	        }
		 if(response.path("bpi.EUR.code") == null){
	            System.out.println("EUR does not exist");
	        }
		 else{
	            System.out.println("Value does  exist : " + response.path("bpi.EUR.code").toString());
	        }
		
	}

}
