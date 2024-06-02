package controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.Dao.ProductDao;
import model.productModel;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet(asyncSupported = true ,urlPatterns = "/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao productDao = new ProductDao();
		
		String prodId = request.getParameter("prodId");
		String prodName = request.getParameter("productName");
		String prodDesc = request.getParameter("productDesc");
		double prodPrice = Double.parseDouble(request.getParameter("productPrice"));
		int prodQuantity = Integer.parseInt(request.getParameter("productQuantity"));
		String prodBrand = request.getParameter("productBrand");
		Part part = request.getPart("photo");
		String path = "FileUpload/product/" + prodName + ".png";
		String imagepath = "C:\\Users\\bimas\\OneDrive\\Desktop\\4 sem\\Advance programming\\coursework\\Crown2\\src\\main\\webapp\\";
        String fullpath = imagepath+ path;
        part.write(fullpath);
		
		productModel product = new productModel(prodId, prodName, prodDesc, path , prodQuantity, prodPrice, prodBrand);
		
		productDao.updateProduct(product);
		
	}

}
