package com.klu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.klu.entity.Pharmacy;
import com.klu.repository.*;

@Service
public class PharmacyServiceImpl implements PharmacyService
{
	@Autowired
	private PharmacyRepository repo;

	@Override
	public Pharmacy addOrder(Pharmacy p) {
		repo.save(p);
		return p;
	}

	@Override
	public String updateOrder(Pharmacy p) {
		if(repo.existsById(p.getPharmacyOrderid())) {
			repo.save(p);
			return "Pharmacy Order updated Successfully";
		}
		else
			return "ID not found";
	}

	@Override
	public String deleteOrder(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Pharmacy Order deletef successfully";
		}
		else
			return "ID not found";
	}

	@Override
	public List<Pharmacy> displayAll() 
	{
			return repo.findAll();
	}

	@Override
	public Optional<Pharmacy> displayById(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<Pharmacy> findbyname(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	@Override
	public List<Pharmacy> findbytype(String type) {
		// TODO Auto-generated method stub
		return repo.findByType(type);
	}

	
}
