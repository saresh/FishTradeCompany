package com.saresh.bionic.main;

import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.saresh.bionic.ws.FishListWS;

@Named
public class ClientApp {
	
	public static void main(String[] args){
		 ApplicationContext context = 
	        		new ClassPathXmlApplicationContext("client-app.xml");
		 FishListWS fishWS = context.getBean(FishListWS.class);
		 String result = fishWS.getFishList();
		 System.out.println(result);
	}
}
