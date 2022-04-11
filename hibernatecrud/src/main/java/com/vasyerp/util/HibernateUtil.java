package com.vasyerp.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.vasyerp.model.Product;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionfFactory() {

		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Product.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
}