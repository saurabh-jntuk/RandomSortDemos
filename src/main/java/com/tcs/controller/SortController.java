
package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcs.service.SortService;
import com.tcs.vo.SortVO;

@Controller
public class SortController {	
	private SortService sortService;
	
	@Autowired(required=true)
	@Qualifier(value="sortService")
	public void setSortService(SortService ps){
		this.sortService = ps;
	}
	//To Display list of sorts done 
	@RequestMapping(value = "/sorts", method = RequestMethod.GET)
	public String listSorts(Model model) {
		model.addAttribute("sort", new SortVO());
		model.addAttribute("listSorts", this.sortService.listSorts());
		return "sort";
	}
	
	//To perform sorting and save sorted sequence in DB
	@RequestMapping(value= "/sort/generateAndSortRandomNumber", method = RequestMethod.POST)
	public String performSorting(){
		this.sortService.sortAndSaveSequence();	
		return "redirect:/sorts";
		
	}
	
	}
