package com.examples.ezoo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.ezoo.dao.DAOUtilities;
import com.examples.ezoo.dao.FeedingScheduleDAO;
import com.examples.ezoo.model.FeedingSchedule;

/**
 * Servlet implementation class UpdateFS
 */
@WebServlet("/UpdateFS")

public class UpdateFS extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// call DAO method
		FeedingScheduleDAO dao = DAOUtilities.getFeedingScheduleDAO();
		// get list of feeding schedules
		List<FeedingSchedule> feedingSchedules = dao.getAllFeedingSchedules();
		// Populate the list into a variable that will be stored in the session
		request.getSession().setAttribute("feedingSchedules", feedingSchedules);
		// Forward browser to jsp
		request.getRequestDispatcher("updateFeedingSchedule.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get Parameters
		// We MUST convert to a Long since parameters are always Strings
				
		String food = request.getParameter("food");

		String notes = request.getParameter("notes");

		// Since request parameters are ALWAYS Strings we will convert them to Double
		double hoursBetweenFeedings = Double.parseDouble(request.getParameter("hoursBetweenFeedings"));

		double numberPounds = Double.parseDouble(request.getParameter("numberPounds"));
		
		long schedule_id = Long.parseLong(request.getParameter("schedule_id"));
		
		// Create a FeedingSchedule object from the parameters
		FeedingSchedule feedingScheduleToUpdate = new FeedingSchedule();
		// remove feeding schedule
				feedingScheduleToUpdate.setFood(food);
				feedingScheduleToUpdate.setNotes(notes);
				feedingScheduleToUpdate.setHoursBetweenFeedings(hoursBetweenFeedings);
				feedingScheduleToUpdate.setNumberPounds(numberPounds);
				feedingScheduleToUpdate.setSchedule_id(schedule_id);
		// Call DAO method
		FeedingScheduleDAO dao = DAOUtilities.getFeedingScheduleDAO();
		
		boolean success = false;
		try {
			success = dao.updateFeedingSchedule(feedingScheduleToUpdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (success) {
			request.getSession().setAttribute("message",
					"Feeding schedule with ID #" + schedule_id + " successfully updated");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("animalCare");
		} else {
			request.getSession().setAttribute("message",
					"There was a problem updating the feeding schedule with ID #" + schedule_id);
			request.getSession().setAttribute("messageClass", "alert-danger");

			request.getRequestDispatcher("updateFeedingSchedule.jsp").forward(request, response);
		}

	}
}