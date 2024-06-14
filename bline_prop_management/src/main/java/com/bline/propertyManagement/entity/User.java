package com.bline.propertyManagement.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

//@Table(name="user")
@Entity
@Data
public class User {

	@Id
	private String userId = UUID.randomUUID().toString();
	private String name;
	private String email;
	private String role;
	
	@OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Tour> tours;

}
