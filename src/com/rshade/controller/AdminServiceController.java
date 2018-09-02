package com.rshade.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rshade.bean.Admin;


@RestController
@CrossOrigin
@RequestMapping(value="/service/admin")
public class AdminServiceController {

	private Logger logger=Logger.getLogger(AdminServiceController.class.getName());
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Admin getAdmin(){
		Admin admin=new Admin();
		admin.setId(100);
		admin.setFirstname("Sumantho");
		admin.setLastname("Karmakar");
		logger.debug("admin:"+admin);
		return admin;
	}
}
