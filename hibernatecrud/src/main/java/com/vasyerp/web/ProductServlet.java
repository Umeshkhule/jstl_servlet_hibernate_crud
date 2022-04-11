package com.vasyerp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vasyerp.dao.ProductDao;
import com.vasyerp.model.Product;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDao productDao;

	public void init()throws ServletException {
		productDao=new ProductDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String flag=request.getParameter("flag");


		if(flag.equals("AddProduct"))
		{
			String productName=request.getParameter("productName");
			long productPrice=Long.parseLong(request.getParameter("productPrice"));
			long productQuantity=Long.parseLong(request.getParameter("productQuantity"));
			Product product=new Product(productName, productPrice, productQuantity);
			productDao.saveProduct(product);
			out.print("Record Inserted");
			request.getRequestDispatcher("index.jsp").include(request, response);
			//productDao.getAllProduct();
			//request.getRequestDispatcher("viewProduct.jsp").include(request, response);
		}

		else if(flag.equals("ViewProduct"))
		{
			HttpSession session=request.getSession();
			List<Product> productlist=productDao.getAllProduct();
			request.setAttribute("productlist", productlist);
			request.getRequestDispatcher("viewProduct.jsp").include(request, response);
		}

		else if(flag.equals("UpdateProduct"))
		{
			HttpSession session=request.getSession();
			long productId=Long.parseLong(request.getParameter("productId"));
			List<Product> productlist=productDao.getProduct(productId);
			session.setAttribute("productlist", productlist);
		//	productDao.getAllProduct();
			request.setAttribute("productlist", productlist);
			request.getRequestDispatcher("editProduct.jsp").include(request, response);			
		}

		else if(flag.equals("DeleteProduct"))
		{
			long productId=Long.parseLong(request.getParameter("productId"));
			productDao.deleteProduct(productId);
			productDao.getAllProduct();
		
			request.getRequestDispatcher("index.jsp").include(request, response);
		}


		else if(flag.equals("UpdateToDB"))
		{
			long productId=Long.parseLong(request.getParameter("productId"));
			String productName=request.getParameter("productName");
			long productPrice=Long.parseLong(request.getParameter("productPrice"));
			long productQuantity=Long.parseLong(request.getParameter("productQuantity"));
			Product product=new Product(productId, productName, productPrice, productQuantity);
			productDao.updateProduct(product);
		//	productDao.getAllProduct();
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}
}