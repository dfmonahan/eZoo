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
 * Servlet implementation class FeedingSchedules
 */
@WebServlet("/FeedingSchedules")

public class FeedingSchedules extends HttpServlet {

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
		request.getRequestDispatcher("feedingSchedules.jsp").forward(request, response);

	}

}
