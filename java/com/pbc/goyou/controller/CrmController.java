package com.pbc.goyou.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pbc.goyou.constant.ViewConstant;
import com.pbc.goyou.entity.GoyouCustomer;
import com.pbc.goyou.entity.GoyouSites;
import com.pbc.goyou.entity.GoyouSource;
import com.pbc.goyou.model.GoyouSourceModel;
import com.pbc.goyou.service.GoyouContactService;
import com.pbc.goyou.service.GoyouCustomerService;
import com.pbc.goyou.service.GoyouSitesService;
import com.pbc.goyou.service.GoyouSourceService;
import com.pbc.goyou.service.GoyouToDoService;

@Controller
@RequestMapping("/crm")
public class CrmController {
	
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
	
	
	@RequestMapping(value = "/refreshTableContact", method = RequestMethod.GET)
	public String refreshTableContact(@RequestParam("customerid") int customerid, Model model) {
	    
		System.out.print("kkkkk");

	    model.addAttribute("contacts", goyouContactService.listContactByUser(goyouCustomerService.findGoyouCustomerById(customerid)));

	    return "myView :: #tablecontact";
	}

	
	@GetMapping("/")
	public ModelAndView Welcome() throws IllegalArgumentException, IllegalAccessException{
		ModelAndView mav = new ModelAndView(ViewConstant.WELCOME);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("user : " + user.getUsername());
		
		mav.addObject("customers", goyouCustomerService.countRecords());
		mav.addObject("contacts", goyouContactService.countRecords());
		mav.addObject("todos", goyouToDoService.countRecords());
		mav.addObject("sources", goyouSourceService.countRecords());
		mav.addObject("username", user.getUsername());
	
		return mav;
	}
	
	@GetMapping("/customers")
	public ModelAndView showCustomers(@RequestParam(name="pageno", required=false, defaultValue="0") int pageno){
		ModelAndView mav = new ModelAndView(ViewConstant.CUSTOMERS);
		
		Page<GoyouCustomer> pagecustomers= goyouCustomerService.listPageableGoyouCustomer(pageno);

		mav.addObject("customers", pagecustomers.getContent());
		mav.addObject("totalpages", pagecustomers.getTotalPages());
		mav.addObject("currentpage", pagecustomers.getNumber());
		mav.addObject("first", pagecustomers.isFirst());
		mav.addObject("last", pagecustomers.isLast());
		mav.addObject("elements",pagecustomers.getNumberOfElements());
		mav.addObject("next", pagecustomers.nextPageable().getPageNumber());
		//mav.addObject("previous", pagecustomers.previousPageable().getPageNumber());
		return mav;
	}
	
	

		
	
	@GetMapping("/customer/{customerid}/addsource")
	public ModelAndView addSource(@PathVariable int customerid){
		ModelAndView mav = new ModelAndView(ViewConstant.ADDSOURCE);
		
		System.out.println("customer" + customerid);
		mav.addObject("goyouSourceModel",new GoyouSourceModel());
		mav.addObject("customerid", customerid);
		mav.addObject("contacts", goyouContactService.listContactByUser(goyouCustomerService.findGoyouCustomerById(customerid)));

		
		return mav;
	}
	
	
	
	@PostMapping("/customer/savesource")
	public ModelAndView SaveSource(@ModelAttribute("goyouSourceModel") @Valid GoyouSourceModel goyouSourceModel, BindingResult result, Model model) {
	
		
		
			System.out.println(goyouSourceModel.getSites());
			
		
		
		
		ModelAndView mav = new ModelAndView(ViewConstant.ADDSOURCE);
		
		System.out.println(goyouSourceModel.getJobdescription());

		if(result.hasErrors()) {
			//mav.addObject("goyouSourceModel",new GoyouSourceModel());
			mav.addObject("customerid", goyouSourceModel.getCustomer());
			mav.addObject("contacts", goyouContactService.listContactByUser(goyouCustomerService.findGoyouCustomerById(goyouSourceModel.getCustomer())));

			return mav;
		}
		
		GoyouSource goyouSource = new GoyouSource();
		
		goyouSource.setContact(goyouContactService.findGoyouContactById(goyouSourceModel.getContact()));
		goyouSource.setCustomer(goyouCustomerService.findGoyouCustomerById(goyouSourceModel.getCustomer()));
		goyouSource.setJobdescription(goyouSourceModel.getJobdescription());
		goyouSource.setSummary(goyouSourceModel.getSummary());
		goyouSource.setStatus(goyouSourceModel.getStatus());

		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = goyouSourceModel.getDatesource();
		try {

			Date date = formatter.parse(dateInString);
			goyouSource.setDatesource(date);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("ABANS");
		 goyouSource = goyouSourceService.addGoyouSource(goyouSource);
		System.out.println("DESPRES");
		
		
		if (!goyouSourceModel.getSites().isEmpty()) {			
			String[] parts = goyouSourceModel.getSites().split(",");
			
			if (parts.length>0) {
				for (String string : parts) {
					GoyouSites sites = new GoyouSites();
					sites.setSites(string);
					sites.setSource(goyouSource);
					goyouSitesService.addGoyouSites(sites);
					
				}
			}
		}
		
		
		mav = new ModelAndView(ViewConstant.CUSTOMERS);
		
		Page<GoyouCustomer> pagecustomers= goyouCustomerService.listPageableGoyouCustomer(0);

		mav.addObject("customers", pagecustomers.getContent());
		mav.addObject("totalpages", pagecustomers.getTotalPages());
		mav.addObject("currentpage", pagecustomers.getNumber());
		mav.addObject("first", pagecustomers.isFirst());
		mav.addObject("last", pagecustomers.isLast());
		mav.addObject("elements",pagecustomers.getNumberOfElements());
		mav.addObject("next", pagecustomers.nextPageable().getPageNumber());
		//mav.addObject("previous", pagecustomers.previousPageable().getPageNumber());
		return mav;
	}

}
