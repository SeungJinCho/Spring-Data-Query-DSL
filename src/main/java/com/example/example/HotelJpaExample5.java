package com.example.example;

import com.example.entity.Hotel;
import com.example.entity.QHotel;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by seungjin.cho | Jin | TRVDD on 11/8/16.
 */
@Repository
public class HotelJpaExample5 extends QueryDslRepositorySupport {

	private static QHotel qHotel = QHotel.hotel;

	public HotelJpaExample5() {
		super(HotelJpaExample5.class);
	}

	/**
	 * example of Querydsl (Dynamic Query)
	 */
	private List<Hotel> getHotelsByLikeName(String name, Integer rating, int limit) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if (!StringUtils.isEmpty(name)) {
			booleanBuilder.and(qHotel.name.startsWith(name));
		}
		if (rating != null && rating > 0) {
			booleanBuilder.and(qHotel.rating.gt(rating));
		}
		return from(qHotel).where(booleanBuilder).limit(limit).fetch();
	}


}
