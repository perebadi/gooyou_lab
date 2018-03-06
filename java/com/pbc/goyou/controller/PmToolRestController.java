package com.pbc.goyou.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pbc.goyou.entity.GoyouContact;
import com.pbc.goyou.model.GoyouContactModel;
import com.pbc.goyou.service.GoyouContactService;
import com.pbc.goyou.service.GoyouCustomerService;
import com.pbc.goyou.service.GoyouSitesService;
import com.pbc.goyou.service.GoyouSourceService;
import com.pbc.goyou.service.GoyouToDoService;
import com.pbc.goyou.model.Response;


@RestController
@RequestMapping("/api/")
public class PmToolRestController {

	@Autowired
	@Qualifier("goyouCustomerServiceImpl")
	private GoyouCustomerService goyouCustomerService;
	
	@Autowired
	@Qualifier("goyouSourceServiceImpl")
	private GoyouSourceService goyouSourceService;
	
	@Autowired
	@Qualifier("goyouToDoServiceImpl")
	private GoyouToDoService goyouToDoService;
	
	@Autowired
	@Qualifier("goyouContactServiceImpl")
	private GoyouContactService goyouContactService;
	
	@Autowired
	@Qualifier("goyouSitesServiceImpl")
	private GoyouSitesService goyouSitesService;
	

	@PostMapping(value = "/addcontact/")
	public Response addcontact(@RequestBody GoyouContactModel goyouContactModel) throws ParseException {
		Response res = null;
		
		GoyouContact goyouContact = new GoyouContact();
		
		
		goyouContact.setContactname(goyouContactModel.getContactname());
		goyouContact.setEmail(goyouContactModel.getEmail());
		goyouContact.setPosition(goyouContactModel.getPosition());
		goyouContact.setLandphone(goyouContactModel.getLandphone());
		goyouContact.setMobilephone(goyouContactModel.getMobilephone());

		goyouContact.setCustomer(goyouCustomerService.findGoyouCustomerById(goyouContactModel.getCustomerid()));
		goyouContact.setType("Principal");

		Date date = new Date();			
		goyouContact.setStartdate(date);
		
		
		
		goyouContact=goyouContactService.addGoyouContact(goyouContact);
		
		if(goyouContact.getId()>0) {
			return new Response("Done", goyouContact.getId()+","+goyouContact.getContactname());
		}
		else {
			return new Response("Error", "Error");

		}
	}

	

}
