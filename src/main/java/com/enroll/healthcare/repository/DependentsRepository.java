package com.enroll.healthcare.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enroll.healthcare.model.Dependents;

@Repository
@Transactional
public interface DependentsRepository extends CrudRepository<Dependents, Integer>{
	
	Dependents save(Dependents enrollees);
	
	void deleteById(Integer id);

	Optional<Dependents> findById(Integer id);

}
