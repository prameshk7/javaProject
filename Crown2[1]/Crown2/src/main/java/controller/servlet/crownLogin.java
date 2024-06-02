package controller.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Dao.UserDao;
import util.crownStringUtils;



@WebServlet(asyncSupported = true, urlPatterns = { "/crownLogin" })
public class crownLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao dbController = new UserDao();       

    public crownLogin() {
        super();
   
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        System.out.println(email);
        System.out.println(password);
        
        
        
        RequestDispatcher dispatcher = null;
        int loginresult = dbController.getUserinfo(email, password);
        
        if (loginresult == 1) {
        	
        	String userName = dbController.getuserName(email);

        	
        	HttpSession userSession = request.getSession();
        	userSession.setAttribute("usermail", email);
        	userSession.setAttribute("userName", userName);
        	userSession.setMaxInactiveInterval(30*60);
        	
        	Cookie userCookie = new Cookie("usermail", email);
        	userCookie.setMaxAge(30*60);
        	response.addCookie(userCookie);

        	dispatcher = request.getRequestDispatcher("viewpage/success.jsp");
        }
		else {
			request.setAttribute(crownStringUtils.ERROR_MESSAGE, crownStringUtils.ERROR_LOGIN_MESSAGE);
			dispatcher = request.getRequestDispatcher("viewpage/crownlogin.jsp");
		}
		dispatcher.forward(request, response);
	
	}

	
}
