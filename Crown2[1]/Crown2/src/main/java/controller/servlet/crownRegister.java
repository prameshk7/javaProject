package controller.servlet;

import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

import controller.Dao.UserDao;
import model.UserModel;
import util.IdGenerator;

import util.crownStringUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/crownRegister" })

public class crownRegister extends HttpServlet {
		private static final long serialVersionUID = 1L;
      

    public crownRegister() {
        super();

    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = new IdGenerator().getUserId();
		String userName = request.getParameter(crownStringUtils.USER_NAME);
		String firstName = request.getParameter(crownStringUtils.FIRST_NAME);
		String lastName = request.getParameter(crownStringUtils.LAST_NAME);
		String email = request.getParameter(crownStringUtils.EMAIL);
		String password = request.getParameter(crownStringUtils.PASSWORD);
		String confirmpass = request.getParameter(crownStringUtils.CONFIRM_PASSWORD);

		if (password.equals(confirmpass)) {
            if (userName == null || userName.isEmpty()) {
                request.setAttribute(crownStringUtils.ERROR_MESSAGE, crownStringUtils.USERNAME_ERROR_MESSAGE);
                request.getRequestDispatcher("/viewpage/crownregister.jsp").forward(request, response);
                
            } else if (email == null || email.isEmpty()) {
                request.setAttribute(crownStringUtils.ERROR_MESSAGE, crownStringUtils.EMAIL_ERROR_MESSAGE);
                request.getRequestDispatcher("/viewpage/crownregister.jsp").forward(request, response);
                
            } else {
            	UserModel user = new UserModel(userId, userName, firstName, lastName, email, password, confirmpass);	
            	String message = new UserDao().addUser(user);

            	switch (message) {
                case crownStringUtils.SUCCESS_REGISTER_MESSAGE:
                    request.setAttribute(crownStringUtils.SUCCESS_MESSAGE, crownStringUtils.SUCCESS_REGISTER_MESSAGE);
                    response.sendRedirect(request.getContextPath() + "/viewpage/crownlogin.jsp");
                    break;
                case crownStringUtils.USERNAME_ERROR_MESSAGE:
                    request.setAttribute(crownStringUtils.ERROR_MESSAGE, crownStringUtils.USERNAME_ERROR_MESSAGE);
                    request.getRequestDispatcher("/viewpage/crownregister.jsp").forward(request, response);
                    break;
                case crownStringUtils.EMAIL_ERROR_MESSAGE:
                    request.setAttribute(crownStringUtils.ERROR_MESSAGE, crownStringUtils.EMAIL_ERROR_MESSAGE);
                    request.getRequestDispatcher("/viewpage/crownregister.jsp").forward(request, response);
                    break;
                case crownStringUtils.FIRST_NAME_ERROR_MESSAGE:
                    request.setAttribute(crownStringUtils.ERROR_MESSAGE, crownStringUtils.FIRST_NAME_ERROR_MESSAGE);
                    request.getRequestDispatcher("/viewpage/crownregister.jsp").forward(request, response);
                    break;
                case crownStringUtils.LAST_NAME_ERROR_MESSAGE:
                    request.setAttribute(crownStringUtils.ERROR_MESSAGE, crownStringUtils.LAST_NAME_ERROR_MESSAGE);
                    request.getRequestDispatcher("/viewpage/crownregister.jsp").forward(request, response);
                    break;    
                case crownStringUtils.SERVER_ERROR_MESSAGE:
                	break;
                default:
                    request.setAttribute(crownStringUtils.ERROR_MESSAGE, crownStringUtils.SERVER_ERROR_MESSAGE);
                    request.getRequestDispatcher("/viewpage/crownregister.jsp").forward(request, response);
                    break;
            	}
            }
		}else {
			request.setAttribute(crownStringUtils.ERROR_MESSAGE, crownStringUtils.PASSWORD_UNMATCHED_ERROR_MESSAGE);
            request.getRequestDispatcher("/viewpage/crownregister.jsp").forward(request, response);
            }
	
		}
	}

	













//
//if (crownStringUtils.SUCCESS_REGISTER_MESSAGE.equals(message)) {
//  response.sendRedirect(request.getContextPath() + "/viewpage/crownlogin.jsp");
//} else {
//  request.setAttribute(crownStringUtils.ERROR_MESSAGE, message);
//  request.getRequestDispatcher("/viewpage/crownregister.jsp").forward(request, response);
//}
//



//        if (userName == null || firstName == null || lastName == null || email == null || password == null
//                || confirmpass == null || !password.equals(confirmpass)) {
//            request.setAttribute(crownStringUtils.ERROR_MESSAGE, crownStringUtils.ERROR_REGISTER_MESSAGE);
//            request.getRequestDispatcher("/viewpage/crownregister.jsp").forward(request, response);
//            return;
//        }
//

//if (message.equals("Successful Registration")){
//response.sendRedirect("viewpage/crownlogin.jsp");
//}