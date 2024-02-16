package com.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.binding.Product;

import jakarta.validation.Valid;

@Controller
public class ProductController {
	
	//method to display the form
	@GetMapping
	public String loadForm(Model model) {
		model.addAttribute("product", new Product());
		
		return "index";
	}
	
	//method to handle the form submission
	
	@PostMapping("/product")
	public String handleSubmitBtn(@Valid Product p,BindingResult result,Model model) {
		System.out.println(p);
		
		if(result.hasErrors()) {
			return "index";
		}else {
			model.addAttribute("nit", "Product Saved");
		}
	
		return "index";
	}
}
