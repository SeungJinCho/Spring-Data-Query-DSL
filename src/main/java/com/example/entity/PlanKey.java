package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

/**
 * Created by seungjin.cho | Jin | TRVDD on 11/7/16.
 */
@Data
@Embeddable
public class PlanKey implements Serializable {

	@Column(name = "ID")
	@GeneratedValue
	private Long Id;

	@Column(name = "HOTEL_ID")
	private Long hotelId;

}
