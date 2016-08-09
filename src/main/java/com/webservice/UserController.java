package com.webservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{

	@CrossOrigin(origins = "*")
	@RequestMapping(value="/user/{userName}", method = RequestMethod.GET)
//    public User users(@RequestParam(value="uname", defaultValue="") String uName) {
	  public User users(@PathVariable String userName) {
		return UserDAO.getUserDataByUsername(userName);
		//Verify the content of the User object
		//if(temp.getUserID()!=-1){
			//The user is valid
			//return temp.toString();
		//}
//		return temp;
    }

}
