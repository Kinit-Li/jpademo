package com.ligy.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ligy.jpademo.model.User;

public class JpaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void createTable() {
		// 可以验证生成表是否正确
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");
		factory.close();
	}

	@Test
	public void save() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		User user = new User(); // person为new状态
		user.setUsername("zhang san");
		user.setPassword("111111");
		em.persist(user); // 持久化实体
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	// new 、托管、脱管、删除

	@Test
	public void update() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, "4028954157619df20157619df5b80001");
		user.setUsername("hmk"); // person为托管状态
		user.setPassword("2222222222");
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	@Test
	public void update2() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, "4028954157619df20157619df5b80001");
		em.clear(); // 把实体管理器中的所有实体变为脱管状态
		user.setUsername("hmk3");
		em.merge(user); // 把脱管状态变为托管状态,merge可以自动选择insert or update 数据
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	@Test
	public void remove() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, "4028954157619df20157619df5b80001");
		em.remove(user); // 删除实体
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	@Test
	public void find() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		User user = em.find(User.class, "4028954157619d650157619d69170001"); // 类似于hibernate的get方法,没找到数据时，返回null
		System.out.println(user.getUsername());
		em.close();
		factory.close();
	}

	@Test
	public void find2() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		User user = em.getReference(User.class, "4028954157619d650157619d69170001"); // 类似于hibernate的load方法,延迟加载.没相应数据时会出现异常
		System.out.println(user.getUsername()); // 真正调用时才查找数据
		em.close();
		factory.close();
	}

}
