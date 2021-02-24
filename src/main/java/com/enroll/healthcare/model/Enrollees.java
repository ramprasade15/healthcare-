package com.enroll.healthcare.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrollees {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="enrollees_id")
	private int id;
	
	private String name;
	
	@Column(name ="activation_status")
	private Boolean activationStatus;
	
	@Column(name ="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name ="phone_number")
	private Long phoneNumber;
	
	@OneToMany(mappedBy = "enrollees", targetEntity = Dependents.class, cascade = CascadeType.ALL)
	private List<Dependents> dependents;
	

}
