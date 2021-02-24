package com.enroll.healthcare.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.enroll.healthcare.model.Enrollees;


@Repository
@Transactional
public interface EnrolleesRepository extends CrudRepository<Enrollees, Integer>{
	
	Enrollees save(Enrollees enrollees);
	
	void deleteById(Integer id);
	
	Optional<Enrollees> findById(Integer id);


}
