package controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(asyncSupported = true, urlPatterns = { "/crownLogout" })
public class crownLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Session remove
        HttpSession userSession = request.getSession(false);
        if (userSession != null) {
            userSession.invalidate(); 
        }

        // Delete user cookie
        Cookie[] userCookie = request.getCookies();
        if (userCookie != null) {
            for (Cookie cookie : userCookie) {
                if (cookie.getName().equals("usermail")) {
                    cookie.setMaxAge(0); 
                    response.addCookie(cookie);
                    break;
                }
            }
        }


        response.sendRedirect("viewpage/crownlogin.jsp");
    }
}
		
		