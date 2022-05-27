package com.bookstore.controller;

import java.security.PublicKey;
import java.util.Iterator;

import com.bookstore.entity.UserAccount;
import com.bookstore.helper.RegisterHelper;
import com.bookstore.model.CacheMemory;



public class Controller {
	
	RegisterHelper helper = new RegisterHelper();
	String result = null;

	public boolean login(String userName, String password) {
		String result= helper.isPwdValid(userName);
		if (result.equals(password) && result!=null) {
			CacheMemory.loggedUsername = userName;
			return true;
		}
	
		else 
			return false;
		
	}


	public boolean register(String name, String age, String userName, String password, String cfPassword, String email,
			String phone, String address) {
		if (password.equals(cfPassword)) {
			UserAccount userAccount = new UserAccount();
			userAccount.setName(name);
			userAccount.setAge(age);
			userAccount.setUserName(userName);
			userAccount.setPassword(password);
			userAccount.setEmail(email);
			userAccount.setPhone(phone);
			userAccount.setAddress(address);
			return helper.registerAccount(userAccount);
		} else {
			return false;
		}

	}

}
