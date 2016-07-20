package com.webservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{
	User userFound;

	@RequestMapping(value="/users", method = RequestMethod.GET)
    public String users(@RequestParam(value="firstName", defaultValue="") String firstName) {
		User temp= UserDAO.getUserDataByUsername("mpiccoli");
		return temp.toString();
    }

}
