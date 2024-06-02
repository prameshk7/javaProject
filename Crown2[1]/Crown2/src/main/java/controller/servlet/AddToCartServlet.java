package controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Dao.CartDao;
import model.CartModel;
import util.IdGenerator;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet(asyncSupported = true ,urlPatterns = "/AddToCartServlet")
@MultipartConfig
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDao cartDao = new CartDao();
		
		String cardId = new IdGenerator().getCartId();
		String userId = request.getParameter("userId"); 
		String prodId = request.getParameter("prodId");
		int quantity = 1;
		
		CartModel cart = new CartModel(cardId, userId, prodId, quantity);
		cartDao.addToCart(cart);
	}

}
