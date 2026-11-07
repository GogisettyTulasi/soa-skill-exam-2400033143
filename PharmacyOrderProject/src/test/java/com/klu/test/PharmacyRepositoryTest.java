
package com.klu.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klu.entity.Pharmacy;
import com.klu.repository.PharmacyRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PharmacyRepositoryTest 
{
    @Autowired
    private PharmacyRepository repository;

    @Test
    void testFindAll() 
    {
        List<Pharmacy> pharmacies = repository.findAll();
        assertNotNull(pharmacies);
        assertFalse(pharmacies.isEmpty());
        System.out.println("Total Pharmacies: " + pharmacies.size());
    }

    @Test
    void testFindById() 
    {
        Optional<Pharmacy> pharmacy = repository.findById(2L);
        assertTrue(pharmacy.isPresent());
        assertEquals(2L, pharmacy.get().getPharmacyOrderid());
        System.out.println("Pharmacy ID: " + pharmacy.get().getPharmacyOrderid());
    }

    @Test
    void testFindPharmacyByName() 
    {
        Optional<Pharmacy> pharmacy = repository.findByName("Gojo").stream().findFirst();
        assertTrue(pharmacy.isPresent());
        assertEquals("Gojo", pharmacy.get().getName());
        System.out.println("Name: " + pharmacy.get().getName());
        System.out.println("Type: " + pharmacy.get().getType());
    }

    @Test
    void testFindPharmacyByType() 
    {
        Optional<Pharmacy> pharmacy = repository.findByType("Medicine").stream().findFirst();
        assertTrue(pharmacy.isPresent());
        assertEquals("Medicine", pharmacy.get().getType());
        System.out.println("Type: " + pharmacy.get().getType());
        System.out.println("Name: " + pharmacy.get().getName());
    }

    @Test
    void testCount() 
    {
        long count = repository.count();
        assertTrue(count >= 0);
        System.out.println("Total Pharmacies in Database: " + count);
    }

    @Test
    void testPharmacyDetails() 
    {
        Optional<Pharmacy> pharmacy = repository.findById(2L);
        assertTrue(pharmacy.isPresent());
        Pharmacy foundPharmacy = pharmacy.get();
        assertNotNull(foundPharmacy.getName());
        assertNotNull(foundPharmacy.getStatus());
        assertNotNull(foundPharmacy.getType());
        assertNotNull(foundPharmacy.getLoc());
        System.out.println("Name: " + foundPharmacy.getName());
        System.out.println("Status: " + foundPharmacy.getStatus());
        System.out.println("Type: " + foundPharmacy.getType());
        System.out.println("Location: " + foundPharmacy.getLoc());
    }
}
