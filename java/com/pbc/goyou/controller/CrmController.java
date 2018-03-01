package com.pbc.goyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pbc.goyou.constant.ViewConstant;
import com.pbc.goyou.entity.GoyouCustomer;
import com.pbc.goyou.service.GoyouContactService;
import com.pbc.goyou.service.GoyouCustomerService;
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
		
		System.out.println("jsdknkdsknsd");

		return mav;
	}

}
