package com.webservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{
	private User userFound;

	@RequestMapping(value="/users", method = RequestMethod.GET)
    public User users(@RequestParam(value="uname", defaultValue="") String uname) {
		User temp= UserDAO.getUserDataByUsername(uname);
		//Verify the content of the User object
		//if(temp.getUserID()!=-1){
			//The user is valid
			//return temp.toString();
		//}
		return temp;
    }

}
