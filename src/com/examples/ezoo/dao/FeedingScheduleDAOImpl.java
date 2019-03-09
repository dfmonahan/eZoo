package com.examples.ezoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.examples.ezoo.dao.DAOUtilities;
import com.examples.ezoo.model.FeedingSchedule;

/**
 * @author Davida Monohan
 *
 */
public class FeedingScheduleDAOImpl implements FeedingScheduleDAO {

	@Override
	public List<FeedingSchedule> getAllFeedingSchedules() {
		/**
		 * Used to retrieve a list of all Feeding Schedules
		 * 
		 * @return
		 */
		List<FeedingSchedule> feedingSchedules = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = DAOUtilities.getConnection();

			stmt = connection.createStatement();

			String sql = "SELECT * FROM \"feedingSchedules\"";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				FeedingSchedule fs = new FeedingSchedule();

				fs.setSchedule_id(rs.getLong("schedule_id"));
				fs.setFood(rs.getString("food"));
				fs.setNotes(rs.getString("notes"));
				fs.setHoursBetweenFeedings(rs.getDouble("hoursBetweenFeedings"));
				fs.setNumberPounds(rs.getDouble("numberPounds"));
				feedingSchedules.add(fs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return feedingSchedules;
	}

	@Override
	public void saveFeedingSchedule(FeedingSchedule feedingScheduleToSave) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO \"feedingSchedules\" VALUES (?,?,?,?,?)";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters from feedingSchedule into PreparedStatement
			stmt.setLong(1, feedingScheduleToSave.getSchedule_id());
			stmt.setString(2, feedingScheduleToSave.getFood());
			stmt.setString(3, feedingScheduleToSave.getNotes());
			stmt.setDouble(4, feedingScheduleToSave.getHoursBetweenFeedings());
			stmt.setDouble(5, feedingScheduleToSave.getNumberPounds());
			success = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (success == 0) {
			// then update didn't occur, throw an exception
			throw new Exception("Insert feeding schedule failed: " + feedingScheduleToSave);
		}
	}

	@Override
	public boolean deleteFeedingSchedule(FeedingSchedule scheduleToDelete) {
		Connection connection = null;
		PreparedStatement stmt = null;
		boolean rowDeleted = false;

		try {
			connection = DAOUtilities.getConnection();

			String sql = "DELETE FROM \"feedingSchedules\" WHERE schedule_id = ?";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);
			// Add id from feedingSchedule into PreparedStatement
			stmt.setLong(1, scheduleToDelete.getSchedule_id());

			rowDeleted = stmt.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rowDeleted;

	}

	@Override
	public boolean updateFeedingSchedule(FeedingSchedule feedingScheduleToUpdate) {
		
		Connection connection = null;
		
		PreparedStatement stmt = null;
		
		boolean rowUpdated = false;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE \"feedingSchedules\" SET food = ?, notes = ?,\"hoursBetweenFeedings\" = ?, \"numberPounds\" = ? WHERE schedule_id = ?";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters from feedingSchedule into PreparedStatement
			
			stmt.setString(1, feedingScheduleToUpdate.getFood());
			stmt.setString(2, feedingScheduleToUpdate.getNotes());
			stmt.setDouble(3, feedingScheduleToUpdate.getHoursBetweenFeedings());
			stmt.setDouble(4, feedingScheduleToUpdate.getNumberPounds());
			stmt.setLong(5, feedingScheduleToUpdate.getSchedule_id());
			rowUpdated = stmt.executeUpdate() > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rowUpdated;
		}
	}

		
