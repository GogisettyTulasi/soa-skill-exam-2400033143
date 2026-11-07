package com.klu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.entity.Pharmacy;
import com.klu.service.*;

@RestController 
@RequestMapping("/pharmacy")
public class PharmacyController 
{
	@Autowired
	private PharmacyService service;
	
	@GetMapping("/")
	public String Home()
	{
		return "Pharmacy Service is running..."; 
	}
	
	@PostMapping("/add")
	public Pharmacy insertOrder(@RequestBody Pharmacy p)
	{
		return service.addOrder(p);
	}
	
	@PutMapping("/update")
	public String updateOrder(@RequestBody Pharmacy p)
	{
		return service.updateOrder(p); 
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteOrder(@PathVariable Long id)
	{
		return service.deleteOrder(id);
	}
	
	@GetMapping("/displayall")
	public List<Pharmacy> displayall()
	{
		return service.displayAll();
	}
	
	@GetMapping("/displaybyid/{id}")
	public Optional<Pharmacy> displayById(@PathVariable Long id)
	{
		return service.displayById(id);
	}
	
	@GetMapping("/findbyname/{name}")
	public List<Pharmacy> findbyname(@PathVariable String name)
	{
		return service.findbyname(name);
	}
	
	@GetMapping("/findbytyepe/{type}")
	public List<Pharmacy> findbytype(@PathVariable String type)
	{
		return service.findbytype(type);
	}
	
}
