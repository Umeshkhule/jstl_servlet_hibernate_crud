package com.vasyerp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vasyerp.model.Product;
import com.vasyerp.util.HibernateUtil;

public class ProductDao {

	public void saveProduct(Product product) {
		Transaction transaction=null;
		
		try(Session session=HibernateUtil.getSessionfFactory().openSession()){
			transaction=session.beginTransaction();
			session.save(product);
			System.out.println(product.getProductId());
			System.out.println(product.getProductName());
			System.out.println(product.getProductPrice());
			System.out.println(product.getProductQuantity());
			transaction.commit();
			session.close();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public void updateProduct(Product product) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionfFactory().openSession()){
			transaction=session.beginTransaction();
			Query q=session.createQuery("update Product set productName=:name ,productPrice=:price ,productQuantity=:quantity where"
					+ " productId=:id");
			q.setParameter("name",product.getProductName());
			q.setParameter("price", product.getProductPrice());
			q.setParameter("quantity",product.getProductQuantity());
			q.setParameter("id",product.getProductId());
			q.executeUpdate();
			
			System.out.println(product.getProductId());
			System.out.println(product.getProductName());
			System.out.println(product.getProductPrice());
			System.out.println(product.getProductQuantity());
			System.out.println("Record updated");
//			session.update(product);
			transaction.commit();
		}catch (Exception e) {
			if(transaction !=null ) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public void deleteProduct(long productId) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionfFactory().openSession()){
			transaction=session.beginTransaction();
			System.out.println(productId);
			Query query=session.createQuery("delete Product where productId="+productId);
			int rowCount=query.executeUpdate();
//			Product product=session.get(Product.class,productId);
//			if(product != null) {
//				session.delete(product);
//				System.out.println("Product Deleted");
//			}
			transaction.commit();
		}catch (Exception e) {
			if(transaction !=null ) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public List getProduct(long productId) {
		Transaction transaction=null;
		List<Product> productlist=null;
		try(Session session=HibernateUtil.getSessionfFactory().openSession()){
			transaction=session.beginTransaction();
			productlist=session.createQuery("from Product where productId="+productId).list();
			//product=session.get(Product.class,productId);
			transaction.commit();
		}	catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
			e.printStackTrace();
		}
		
		return productlist;
	}
	public List<Product> getAllProduct(){
		Transaction transaction=null;
		List<Product> productlist=new ArrayList<>();
		try(Session session=HibernateUtil.getSessionfFactory().openSession()){
			transaction=session.beginTransaction();
			productlist=session.createQuery("from Product").getResultList();
			//transaction.commit();
		}catch (Exception e) {
//			if(transaction != null) {
//				transaction.rollback();
//			}
			e.printStackTrace();
		}
		return productlist;
	}
}
