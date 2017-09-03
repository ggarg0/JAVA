package com.mkyong.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

	 @RequestMapping(value="/hello", method = RequestMethod.GET)
	   //, produces = MediaType.APPLICATION_JSON_VALUE)
	   public String hello(){
	      return "Hello Agaian";
	  }
}
