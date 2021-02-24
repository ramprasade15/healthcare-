package com.enroll.healthcare.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class Dependents {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dependents_id")
	private int id;
	
	private String name;
	
	@Column(name ="date_of_birth")
	private Date dateOfBirth;
	
	@ManyToOne
	@JoinColumn(name = "enrollees_id")
	private Enrollees enrollees;
}
