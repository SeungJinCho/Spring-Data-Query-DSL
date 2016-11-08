package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by seungjin.cho | Jin | TRVDD on 11/7/16.
 */
@Entity
@Data
@Table(name = "PLANS")
public class Plan implements Serializable {

	@EmbeddedId
	private PlanKey id;

	@Column(name = "PLAN_START", nullable = false)
	private Date planStart;

	@Column(name = "PLAN_END", nullable = false)
	private Date planEnd;

	@Column(name = "IMAGE_URL")
	private String imageUrl;

}
