package com.examples.ezoo.servlets;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.ezoo.dao.DAOUtilities;
import com.examples.ezoo.dao.FeedingScheduleDAO;
import com.examples.ezoo.model.FeedingSchedule;

/**
 * Servlet implementation class AddFeedingScheduleServlet
 */
@WebServlet("/AddFeedingScheduleServlet")

public class AddFeedingScheduleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("AddFeedingSchedule.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get Parameters
		// We MUST convert to a Long since parameters are always Strings

		long schedule_id = Long.parseLong(request.getParameter("schedule_id"));

		String food = request.getParameter("food");

		String notes = request.getParameter("notes");

		// Since request parameters are ALWAYS Strings we will convert them to Double
		double hoursBetweenFeedings = Double.parseDouble(request.getParameter("hoursBetweenFeedings"));

		double numberPounds = Double.parseDouble(request.getParameter("numberPounds"));

		// Create a FeedingSchedule object from the parameters
		FeedingSchedule feedingScheduleToSave = new FeedingSchedule(schedule_id, food, notes, hoursBetweenFeedings,
				numberPounds);

		// Call DAO method
		FeedingScheduleDAO dao = DAOUtilities.getFeedingScheduleDAO();
		try {
			dao.saveFeedingSchedule(feedingScheduleToSave);
			request.getSession().setAttribute("message", "FeedingSchedule successfully created");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("AddFeedingScheduleServlet");

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();

			// change the message
			request.getSession().setAttribute("message",
					"Id of " + feedingScheduleToSave.getSchedule_id() + " is already in use");
			request.getSession().setAttribute("messageClass", "alert-danger");

			request.getRequestDispatcher("AddFeedingSchedule.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();

			// change the message
			request.getSession().setAttribute("message",
					"There was a problem creating the FeedingSchedule at this time");
			request.getSession().setAttribute("messageClass", "alert-danger");

			request.getRequestDispatcher("AddFeedingSchedule.jsp").forward(request, response);

		}
	}

}
