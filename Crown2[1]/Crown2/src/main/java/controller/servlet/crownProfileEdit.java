package controller.servlet;

import controller.Dao.UserDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(asyncSupported = true, urlPatterns = { "/crownProfileEdit" })
@MultipartConfig
public class crownProfileEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String userimagePath = "FileUpload/profile/"+username+".png";
        //Image work done here
        Part image = request.getPart("image");
        String imagepath = "C:\\Users\\Legion\\eclipse-workspace\\CrownLaptopApp\\src\\main\\webapp\\";
        String fullpath = imagepath+userimagePath;
        image.write(fullpath);

        

        
        // Update user profile in the database
        String usermail = (String) request.getSession().getAttribute("usermail");
        UserDao userDao = new UserDao();
        userDao.updateUserProfile(usermail, username, firstname, lastname);
        
        
        
        request.getSession().setAttribute("username", username);

        // redirects to homepage this
        request.getRequestDispatcher("viewpage/success.jsp").forward(request, response);
    }

}
