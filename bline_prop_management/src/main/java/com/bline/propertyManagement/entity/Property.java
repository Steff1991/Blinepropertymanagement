package com.bline.propertyManagement.entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
public class Property {
	 @Id
	    private String propertyId = UUID.randomUUID().toString();
	 
	@Column(name="address")
	    private String address;
	@Column(name="description")
	    private String description;
}
