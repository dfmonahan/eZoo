package com.examples.ezoo.dao;

import com.examples.ezoo.dao.FeedingScheduleDAO;
import com.examples.ezoo.dao.FeedingScheduleDAOImpl;
import com.examples.ezoo.model.FeedingSchedule;
import java.util.List;


public class TestFeedingScheduleDAO  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FeedingScheduleDAO dao = new FeedingScheduleDAOImpl();
		
		List<FeedingSchedule> list = dao.getAllFeedingSchedules();

		for (int i = 0; i < list.size(); i++) {
			FeedingSchedule f = list.get(i);
			System.out.println(f);
		}
	}
}
