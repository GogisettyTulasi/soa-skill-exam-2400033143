package com.klu.service;

import java.util.List;
import java.util.Optional;

import com.klu.entity.Pharmacy;

public interface PharmacyService
{
	Pharmacy addOrder(Pharmacy p);
	String updateOrder(Pharmacy p);
	String deleteOrder(Long id);
	List<Pharmacy> displayAll();
	Optional<Pharmacy> displayById(Long id);
	List<Pharmacy> findbyname(String name);
	List<Pharmacy> findbytype(String type);
}
