package calendar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.CalendarApi;

/**
 * Servlet implementation class CalendarGetServlet
 */

public class CalendarGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalendarGetServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET");

		String function = request.getParameter("func");
		String account = request.getParameter("account");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		
		if(year == null) {
			year = "0";
		}
		if(month == null) {
			month = "0";
		}
		String result = null;
		
		CalendarApi calendarApi = new CalendarApi();
		result = calendarApi.getJsonAnalyzing(function, account, Integer.parseInt(year), Integer.parseInt(month));

		response.getWriter().append(result);
	}

}
