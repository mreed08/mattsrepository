package com.barista.service;

import org.springframework.stereotype.Service;

@Service
public class ApplicationServices {

	public boolean isNumber(String userInput) {
		try {
    		 Integer.parseInt(userInput);
    		 return true;
    	}
    	catch (NumberFormatException e)
    	{
    		return false;
    	}
		
	}

}
