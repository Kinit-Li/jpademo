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
		// ������֤���ɱ��Ƿ���ȷ
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
		User user = new User(); // personΪnew״̬
		user.setUsername("zhang san");
		user.setPassword("111111");
		em.persist(user); // �־û�ʵ��
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	// new ���йܡ��ѹܡ�ɾ��

	@Test
	public void update() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, "4028954157619df20157619df5b80001");
		user.setUsername("hmk"); // personΪ�й�״̬
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
		em.clear(); // ��ʵ��������е�����ʵ���Ϊ�ѹ�״̬
		user.setUsername("hmk3");
		em.merge(user); // ���ѹ�״̬��Ϊ�й�״̬,merge�����Զ�ѡ��insert or update ����
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
		em.remove(user); // ɾ��ʵ��
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	@Test
	public void find() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		User user = em.find(User.class, "4028954157619d650157619d69170001"); // ������hibernate��get����,û�ҵ�����ʱ������null
		System.out.println(user.getUsername());
		em.close();
		factory.close();
	}

	@Test
	public void find2() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");
		EntityManager em = factory.createEntityManager();
		User user = em.getReference(User.class, "4028954157619d650157619d69170001"); // ������hibernate��load����,�ӳټ���.û��Ӧ����ʱ������쳣
		System.out.println(user.getUsername()); // ��������ʱ�Ų�������
		em.close();
		factory.close();
	}

}
