package com.example.example;

import com.example.entity.Hotel;
import com.example.entity.QHotel;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by seungjin.cho | Jin | TRVDD on 11/8/16.
 */
@Service
public class HotelJpaExample10 {

	@Autowired
	private HotelRepository repository;
	private QHotel qHotel = QHotel.hotel;

	/**
	 *  example of Spring Data + Querydsl
	 */
	public Page<Hotel> findHotels(String name, int limit) {
		return repository.findAll(
				qHotel.name.startsWith(name).and(
						qHotel.rating.gt(0).and(
								qHotel.rating.lt(100)
						)
				), new PageRequest(0, limit));
	}

}
