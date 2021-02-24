package com.enroll.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.enroll.healthcare.model.Dependents;
import com.enroll.healthcare.model.Enrollees;
import com.enroll.healthcare.repository.DependentsRepository;
import com.enroll.healthcare.repository.EnrolleesRepository;

@RestController
public class HealthCareController {
	
	@Autowired
	DependentsRepository dependentsRepository;
	
	@Autowired
	EnrolleesRepository enrolleesRepository;
	
	@PostMapping("/addenrollees")
	public Enrollees addEnrollees(@RequestBody Enrollees enrollees) {
		
		return enrolleesRepository.save(enrollees);
		
	}
	
	@DeleteMapping("/deleteenrollees/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEnrollees(@PathVariable Integer id) {
		 enrolleesRepository.deleteById(id);
		
	}
	
	@PutMapping("/updateenrollees/{id}")
	Enrollees saveOrUpdate(@RequestBody Enrollees enrollees, @PathVariable Integer id) {

        return enrolleesRepository.findById(id)
                .map(x -> {
                	x.setId(id);
                    x.setName(enrollees.getName());
                    x.setPhoneNumber(enrollees.getPhoneNumber());
                    x.setActivationStatus(enrollees.getActivationStatus());
                    x.setDateOfBirth(enrollees.getDateOfBirth());
                    x.setDependents(enrollees.getDependents());
                    return enrolleesRepository.save(x);
                })
                .orElseGet(() -> {
                	enrollees.setId(id);
                    return enrolleesRepository.save(enrollees);
                });
    }
	
	@PostMapping("/adddependents")
	public Dependents addDependents(@RequestBody Dependents dependents) {
		return dependentsRepository.save(dependents);
		
	}
	
	@DeleteMapping("/deletedependents/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteDependents(@PathVariable Integer id) {
		 dependentsRepository.deleteById(id);
		
	}
	
	@PutMapping("/updatedependents/{id}")
	Dependents saveOrUpdate(@RequestBody Dependents dependents, @PathVariable Integer id) {

        return dependentsRepository.findById(id)
                .map(x -> {
                	x.setId(id);
                    x.setName(dependents.getName());
                    x.setDateOfBirth(dependents.getDateOfBirth());
                    return dependentsRepository.save(x);
                })
                .orElseGet(() -> {
                	dependents.setId(id);
                    return dependentsRepository.save(dependents);
                });
    }
	
	
}
