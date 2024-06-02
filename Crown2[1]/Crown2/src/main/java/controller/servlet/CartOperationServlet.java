package controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Dao.CartDao;
import controller.Dao.OrderItemDao;
import util.IdGenerator;

/**
 * Servlet implementation class CartOperationServlet
 */
@WebServlet("/CartOperationServlet")
public class CartOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartOperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String todo = request.getParameter("toDo");
		OrderItemDao orderDao = new OrderItemDao();
		CartDao cartDao = new CartDao();
		
		if(todo.trim().equals("addOrder")) {
			String orderId = new IdGenerator().getOrderId();
			String userId = request.getParameter("userId");
			String prodId = request.getParameter("prodId");
			String quantity = request.getParameter("quantity");
			System.out.print(quantity);
			orderDao.placeOrder(null);
			
		}else if(todo.trim().equals("deleteCart")) {
			String cartId = request.getParameter("cartId");
			cartDao.removeCart(cartId);
			response.sendRedirect(request.getContextPath() + "/viewpage/Cart.jsp");
		}
		
	}

}
