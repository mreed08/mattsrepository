package com.barista;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.barista.service.ApplicationServices;

public class ApplicationServicesTest {

ApplicationServices applicationServices = new ApplicationServices();

	@Test
	public void testIsNumber() {

		assert(applicationServices.isNumber("1"));
		System.out.println("1 is a number");
	
		assert(!applicationServices.isNumber("e"));
		System.out.println("e is not a number");
	}
	

}
