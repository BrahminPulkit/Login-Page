package com.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.MetadataSource;
public class HibernateUtil {
	
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
				
				Map<String , Object> setting = new HashMap<>();
				setting.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
				setting.put(Environment.URL, "jdbc:oracle:thin:@//localhost:1521/XE");
				setting.put(Environment.USER, "System");
				setting.put(Environment.PASS, "root");
				
				registryBuilder.applySettings(setting);
				registry = registryBuilder.build();
				
				MetadataSources source = new MetadataSources(registry).addAnnotatedClass(Employee.class);
				
				Metadata metadata = source.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				// TODO: handle exception
				if (registry == null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	
	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}


}
