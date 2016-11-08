package com.example.example;

import com.example.entity.Hotel;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by seungjin.cho | Jin | TRVDD on 11/8/16.
 */
@Service
public class HotelJpaExample8 {

	@Autowired
	private HotelRepository repository;

	/**
	 *  Spring Data method name query
	 */
	private List<Hotel> getHotelNameLike(String name) {
		return repository.findByNameLikeOrderByRatingDesc(name);
	}

}
