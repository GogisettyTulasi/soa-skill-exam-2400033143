package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.entity.Pharmacy;
import java.util.List;


@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long>
{
	List<Pharmacy> findByName(String name);
	List<Pharmacy> findByType(String type);
	
} 
