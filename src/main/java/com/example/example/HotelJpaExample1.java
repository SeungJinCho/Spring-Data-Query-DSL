package com.example.example;

import com.example.entity.Hotel;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by seungjin.cho | Jin | TRVDD on 11/7/16.
 */
@Repository
public class HotelJpaExample1 {

	@PersistenceContext
	private EntityManager entityManager;

	String query = "select H from HOTEL h where h.name like %s order by h.rating desc";

	/**
	 * example of Direct JPQL(HQL)
	 */
	public Hotel getHotelById(String name) {
		return entityManager.createQuery(String.format(query, name + "%"), Hotel.class).setMaxResults(3).getSingleResult();
	}

}
