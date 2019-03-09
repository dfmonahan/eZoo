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
 * Servlet implementation class AssignFS
 */
/**
 * @author Davida Monohan
 *
 */
@WebServlet("/AssignFS")

public class AssignFS extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// call DAO method
		FeedingScheduleDAO dao = DAOUtilities.getFeedingScheduleDAO();
		// get list of feeding schedules from the database
		AnimalDAO adao = DAOUtilities.getAnimalDAO();
		// get list of Animals from the database
		List<FeedingSchedule> feedingSchedules = dao.getAllFeedingSchedules();
		// Populate the lists into a variable that will be stored in the session
		List<Animal> animals = adao.getAllAnimals();

		request.getSession().setAttribute("feedingSchedules", feedingSchedules);

		request.getSession().setAttribute("animals", animals);

		// Forward browser to jsp
		request.getRequestDispatcher("assignFS.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get Parameters
		// We MUST convert to a Long since parameters are always Strings

		long animalid = Long.parseLong(request.getParameter("animalid"));
		// if schedule_id coming from the form isn't an empty string, then parse it.
		long schedule_id = Long.parseLong(request.getParameter("schedule_id"));

		Animal feedingScheduleToAssign = new Animal();

		feedingScheduleToAssign.setAnimalid(animalid);

		feedingScheduleToAssign.setSchedule_id(schedule_id);
		// add new feeding schedule to animal

		AnimalDAO dao = DAOUtilities.getAnimalDAO();
		// Call DAO method
		boolean success = false;
		try {
			success = dao.assignFeedingSchedule(feedingScheduleToAssign);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (success) {
			request.getSession().setAttribute("message",
					"Feeding schedule with ID #" + schedule_id + " successfully assigned");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("animalCare");
		} else {
			request.getSession().setAttribute("message",
					"There was a problem assigning the feeding schedule with ID #" + schedule_id);
			request.getSession().setAttribute("messageClass", "alert-danger");

			request.getRequestDispatcher("assignFS.jsp").forward(request, response);
		}

	}
}