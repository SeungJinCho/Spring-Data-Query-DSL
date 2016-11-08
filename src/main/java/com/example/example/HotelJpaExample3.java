package com.example.example;

import com.example.entity.Hotel;
import org.springframework.stereotype.Repository;

import com.example.entity.Hotel_;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by seungjin.cho | Jin | TRVDD on 11/7/16.
 */
@Repository
public class HotelJpaExample3 {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * example of Criteria API with MetaModel
	 */
	public List<Hotel> getHotelsByLikeName(String name, int limit) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Hotel> cq = cb.createQuery(Hotel.class);
		Root<Hotel> root = cq.from(Hotel.class);
		return entityManager.createQuery(cq.where(cb.like(root.get(Hotel_.name), name + "%")).orderBy(cb.desc(root.get(Hotel_.rating)))).setMaxResults(limit).getResultList();
	}

}
