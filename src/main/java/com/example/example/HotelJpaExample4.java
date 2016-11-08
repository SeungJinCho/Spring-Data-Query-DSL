package com.example.example;

import com.example.entity.Hotel;
import com.example.entity.QHotel;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by seungjin.cho | Jin | TRVDD on 11/8/16.
 */
@Repository
public class HotelJpaExample4 extends QueryDslRepositorySupport {

	private static QHotel qHotel = QHotel.hotel;

	public HotelJpaExample4() {
		super(HotelJpaExample4.class);
	}

	/**
	 * example of Querydsl
	 */
	public List<Hotel> getHotelsByLikeName(String name, int limit) {
		return from(qHotel)
				.where(qHotel.name.like(name + "%").and(
						qHotel.rating.gt(100).and(qHotel)
				))
				.orderBy(qHotel.rating.desc())
				.limit(limit).fetch();
	}

}

