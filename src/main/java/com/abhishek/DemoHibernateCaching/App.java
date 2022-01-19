package com.abhishek.DemoHibernateCaching;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Alien a1 = new Alien();
//    	Alien a2 = new Alien();
//    	Alien a3 = new Alien();
//    	
//    	a1.setAid(101);
//    	a1.setName("alien1");
//    	a1.setColor("green");
//    	
//    	a2.setAid(102);
//    	a2.setName("alien2");
//    	a2.setColor("blue");
//    	
//    	a3.setAid(103);
//    	a3.setName("alien3");
//    	a3.setColor("yellow");
//    	
//    	Laptop laptop1 = new Laptop();
//    	Laptop laptop2 = new Laptop();
//    	Laptop laptop3 = new Laptop();
//    	Laptop laptop4 = new Laptop();
//    	Laptop laptop5 = new Laptop();
//    	
//    	laptop1.setLid(1);
//    	laptop1.setLname("Dell");
//    	
//    	laptop2.setLid(2);
//    	laptop2.setLname("hp");
//    	
//    	laptop3.setLid(3);
//    	laptop3.setLname("lenovo");
//    	
//    	laptop4.setLid(4);
//    	laptop4.setLname("acer");
//    	
//    	laptop5.setLid(5);
//    	laptop5.setLname("msi");
//    	
//    	a1.getLap().add(laptop1);
//    	a1.getLap().add(laptop2);
//    	a2.getLap().add(laptop3);
//    	a2.getLap().add(laptop4);
//    	a3.getLap().add(laptop5);
//    	
//    	laptop1.setAlien(a1);
//    	laptop2.setAlien(a1);
//    	laptop3.setAlien(a2);
//    	laptop4.setAlien(a2);
//    	laptop5.setAlien(a3);
    	
    	Alien a = null;
    	
    	Configuration confg = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);;
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(confg.getProperties()).buildServiceRegistry();
        SessionFactory sf = confg.buildSessionFactory(reg);
        Session session = sf.openSession();
        
        Session session1 = sf.openSession();
        session.beginTransaction();
        session1.beginTransaction();
        
//        session.save(laptop1);
//        session.save(laptop2);
//        session.save(laptop3);
//        session.save(laptop4);
//        session.save(laptop5);
//        session.save(a1);
//        session.save(a2);
//        session.save(a3);
        
        //a = (Alien) session.get(Alien.class, 101);
        
        Query q1 = session.createQuery("from Alien where aid=101");
        q1.setCacheable(true);
        a = (Alien) q1.uniqueResult();
        System.out.println(a);
        
        //a = (Alien) session1.get(Alien.class, 101);
        session.getTransaction().commit();
        session.close();
        
        Query q2 = session1.createQuery("from Alien where aid=101");
        q2.setCacheable(true); 
        a = (Alien) q2.uniqueResult();
        System.out.println(a);
        
        
        session1.getTransaction().commit();
        
        //session.close();
    }
}
