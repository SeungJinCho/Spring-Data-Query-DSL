package com.example.example;

import com.example.entity.Hotel;
import com.example.entity.QHotel;
import com.example.entity.QPlan;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by seungjin.cho | Jin | TRVDD on 11/8/16.
 */
@Repository
public class HotelJpaExample6 extends QueryDslRepositorySupport {

	private static QHotel qHotel = QHotel.hotel;
	private static QPlan qPlan = QPlan.plan;

	public HotelJpaExample6(){
		super(HotelJpaExample6.class);
	}

	/**
	 * example of Querydsl (Join Query)
	 */
	private List<Hotel> getHotelsByLikeName(String name, int limit) {
		return from(qHotel)
				.join(qHotel.hotelPlans, qPlan)
				.where(
						qPlan.planStart.goe(new Date())
								.and(
									qPlan.planEnd.loe(new Date()))
								.and(
									qHotel.name.startsWith(name)
						)
				)
				.fetch();

	}

}
