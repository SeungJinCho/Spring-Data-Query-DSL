package com.example.example;

import com.example.entity.Hotel;
import com.example.entity.Hotel_;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

/**
 * Created by seungjin.cho | Jin | TRVDD on 11/8/16.
 */
@Service
public class HotelJpaExample9 {

	@Autowired
	private HotelRepository repository;

	/**
	 *  example of DDD Specification
	 */
	private Specification<Hotel> likeName(final String name) {
		return (root, query, cb) -> {
			query.orderBy(cb.desc(root.get(Hotel_.rating)));
			return cb.like(root.get(Hotel_.name), name);
		};
	}

	private Specification limit(final Integer min, final Integer max) {
		return (root, query, cb) -> cb.and(cb.ge(root.get(Hotel_.rating), min), cb.le(root.get(Hotel_.rating), max));
	}

	private Page<Hotel> getHotelNameLike(String name, Integer limit) {
		Specification specs = Specifications.where(likeName(name)).and(limit(0, 100));
		return repository.findAll(specs, new PageRequest(0, limit));
	}

}
