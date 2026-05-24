package com.farmersupport.app.web;

import com.farmersupport.app.dao.ProductDao;
import com.farmersupport.app.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;

    @Override
    public void init() {
        productDao = new ProductDao();
    }

    // Show all products (GET)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> productList = productDao.selectAllProducts();
        request.setAttribute("products", productList);
        request.getRequestDispatcher("view/list-products.jsp").forward(request, response);
    }

    // Add a new product (POST)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int availableQuantity = Integer.parseInt(request.getParameter("available_quantity"));
        String sellerUsername = request.getParameter("seller_username");

        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setDescription(description);
        product.setPrice(price);
        product.setAvailableQuantity(availableQuantity);
        product.setSellerUsername(sellerUsername);

        productDao.insertProduct(product);

        response.sendRedirect("products");
    }
}
