package com.example.repository;

import com.example.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by seungjin.cho | Jin | TRVDD on 11/7/16.
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> , QueryDslPredicateExecutor<Hotel>, JpaSpecificationExecutor<Hotel> {
	List<Hotel> findByNameLikeOrderByRatingDesc(String name);
}
