package user;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.UserApi;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/api/user/password/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		// read json
		BufferedReader reader = request.getReader();
		String json = reader.readLine();
		reader.close();
		System.out.println(json);
		UserApi user = new UserApi();
		String token = user.getValueFromCookie(request.getCookies(), "token");
		// String userAccount = user.getValueFromCookie(request.getCookies(), "userAccount");
		// System.out.println(token + " " + userAccount);
		try {
			boolean result = user.checkUser(json, token);
			System.out.println(result);
			
			if (result == true) response.setStatus(HttpServletResponse.SC_OK); 
			else response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
