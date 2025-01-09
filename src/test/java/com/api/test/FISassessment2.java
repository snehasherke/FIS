package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class FISassessment2 {
	
	
	@Test
	 void apiTest() {
		
		//Fetch response for GET request
		Response response = RestAssured.when().get("https://api.coindesk.com/v1/bpi/currentprice.json");
		
		//check API response is success
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Response Code : "+ response.getStatusCode());
		
		JsonPath jp = response.jsonPath();
		
		//Validate description for GBP
		Assert.assertEquals(jp.get("bpi.GBP.description"), "British Pound Sterling", "Correct value");
		
		Assert.assertEquals(jp.getString("bpi.USD.code"), "USD", "Correct value");
		Assert.assertEquals(jp.getString("bpi.GBP.code"), "GBP", "Correct value");
		Assert.assertEquals(jp.getString("bpi.EUR.code"), "EUR", "Correct value");
		
		//Validate all 3 BPIs are present
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
