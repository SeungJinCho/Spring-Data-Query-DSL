package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by seungjin.cho | Jin | TRVDD on 11/7/16.
 */
@Data
@Entity
@Table(name = "HOTELS")
public class Hotel implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "RATING")
	private Integer rating;

	@JoinColumn(name = "HOTEL_ID")
	@OneToMany(fetch = FetchType.EAGER)
	private List<Plan> hotelPlans;

}
