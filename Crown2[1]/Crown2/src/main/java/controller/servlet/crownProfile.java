package controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class crownProfile
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/crownProfile" })
public class crownProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] userCookie = request.getCookies();
		String usermail = null;
		
        if (userCookie != null) {
            for (Cookie cookie : userCookie) {
                if (cookie.getName().equals("usermail")) {
                    usermail = cookie.getValue();
                    break;
                }
            }
        }
		
		
		if (usermail==null) {
			response.sendRedirect("viewpage/crownlogin.jsp");
		}
		else {
        	response.setContentType("text/html");
        	PrintWriter out = response.getWriter();
        	out.println("<h1>Email="+usermail+"</h1>");
        	out.println("<a href = 'crownLogout'>Logout</a>");
		}
	}

}
