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
import util.IdGenerator;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet(asyncSupported = true ,urlPatterns = "/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao productDao = new ProductDao();
		
		String prodId = new IdGenerator().getProductId();
		String prodName = request.getParameter("productName");
		String prodDesc = request.getParameter("productDesc");
		double prodPrice = Double.parseDouble(request.getParameter("productPrice")) ;
		int prodQuantity = Integer.parseInt(request.getParameter("productQuantity"));
		String prodBrand = request.getParameter("productBrand");
		Part part = request.getPart("photo");
		String path = "FileUpload/product/" + prodName + ".png";
		String imagepath = "C:\\Users\\bimas\\OneDrive\\Desktop\\4 sem\\Advance programming\\coursework\\Crown2\\src\\main\\webapp\\";
        String fullpath = imagepath+ path;
        part.write(fullpath);
        
		productModel product = new productModel(prodId, prodName, prodDesc, path , prodQuantity, prodPrice, prodBrand);
        boolean flag = productDao.addProduct(product);
        
        if(flag) {
        	
        }
		
	}

}
