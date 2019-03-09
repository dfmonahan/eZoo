package com.examples.ezoo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.ezoo.dao.AnimalDAO;
import com.examples.ezoo.dao.DAOUtilities;
import com.examples.ezoo.dao.FeedingScheduleDAO;
import com.examples.ezoo.model.Animal;
import com.examples.ezoo.model.FeedingSchedule;

/**
 * Servlet implementation class DeleteFeedingScheduleServlet
 */
@WebServlet("/DeleteFeedingScheduleServlet")

public class DeleteFeedingScheduleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Grab a list of Animals from the Database
		AnimalDAO dao = DAOUtilities.getAnimalDAO();

		List<Animal> animals = dao.getAllAnimals();

		// Populate the list into a variable that will be stored in the session
		request.getSession().setAttribute("animals", animals);

		// Forward browser to jsp
		request.getRequestDispatcher("deleteFeedingSchedule.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get Parameters
		// We MUST convert to a Long since parameters are always Strings

		long schedule_id = Long.parseLong(request.getParameter("schedule_id"));

		FeedingSchedule scheduleToDelete = new FeedingSchedule();

		scheduleToDelete.setSchedule_id(schedule_id);
		// Call DAO method
		FeedingScheduleDAO dao = DAOUtilities.getFeedingScheduleDAO();

		boolean success = dao.deleteFeedingSchedule(scheduleToDelete);

		if (success) {
			request.getSession().setAttribute("message",
					"Feeding schedule with ID #" + schedule_id + " successfully deleted");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("animalCare");
		} else {
			request.getSession().setAttribute("message",
					"There was a problem deleting the feeding schedule with ID #" + schedule_id);
			request.getSession().setAttribute("messageClass", "alert-danger");

			request.getRequestDispatcher("deleteFeedingSchedule.jsp").forward(request, response);
		}

	}
}