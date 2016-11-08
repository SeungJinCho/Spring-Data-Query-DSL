package com.example.example;

import com.example.entity.Hotel;
import com.example.entity.QHotel;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

/**
 * Created by seungjin.cho | Jin | TRVDD on 11/8/16.
 */
public class HotelJpaExample7 extends QueryDslRepositorySupport {

	public HotelJpaExample7() {
		super(HotelJpaExample7.class);
	}

	private static QHotel qHotel = QHotel.hotel;

	/**
	 * example of Querydsl (Sub Query)
	 */
	public List<Hotel> getHotelByCond(String name, Integer rating) {
		return from(qHotel).where(
				qHotel.in(
						new JPAQuery<Hotel>().from(qHotel)
								.where(qHotel.rating.between(rating - 10, rating + 10))
				)
		).fetch();
	}


}
