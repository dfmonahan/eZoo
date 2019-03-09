package com.examples.ezoo.dao;

import java.util.List;

import com.examples.ezoo.model.FeedingSchedule;

public interface FeedingScheduleDAO {

	/**
	 * Used to retrieve a list of all Feeding Schedules
	 *
	 * @return
	 */
	List<FeedingSchedule> getAllFeedingSchedules();

	/**
	 * Used to persist the feeding schedule to the data store
	 *
	 * @param feedingScheduleToSave
	 * @throws Exception
	 */
	void saveFeedingSchedule(FeedingSchedule feedingScheduleToSave) throws Exception;

	/**
	 * Used to remove the feeding schedule from the data store
	 *
	 * @param feedingScheduleToDelete
	 */

	boolean deleteFeedingSchedule(FeedingSchedule scheduleToDelete);

	/**
	 * Changes parameters of feeding schedule
	 *
	 * @param feedingScheduleToUpdate
	 * @throws Exception
	 */
	boolean updateFeedingSchedule(FeedingSchedule feedingScheduleToUpdate);
	// changes information/values in feeding schedule

	/**
	 * Used to remove the feeding schedule from the data store
	 *
	 * @param feedingScheduleToDelete
	 */
	
}