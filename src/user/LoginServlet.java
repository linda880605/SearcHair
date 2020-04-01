package user;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.userApi;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8"); 
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		// read json
		BufferedReader reader = request.getReader();
		String json = reader.readLine();
		reader.close();
		System.out.println(json);
		// pass json to api
		userApi user = new userApi();
		int result = user.loginJsonAnalyzing(json);
		if (result == 1) {
			response.setStatus(HttpServletResponse.SC_OK);
			
		} else {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}
	}

}