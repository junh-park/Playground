package com.jun.model.hibernate.helloworld;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

import org.testng.annotations.Test;

import com.jun.model.hibernate.env.TransactionManagerTest;

public class StoringMessageUsingJPATest extends TransactionManagerTest {

	@Test
	public void storeLoadMessage() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");
		UserTransaction tx = TM.getUserTransaction();
		
		try {
			{
				tx.begin();
				EntityManager em = emf.createEntityManager();
				Message message = new Message();
				message.setText("Hello World!");
				em.persist(message);
				tx.commit();
				em.close();
			}
			
			{
				UserTransaction tx1 = TM.getUserTransaction();
				tx1.begin();
				
				EntityManager em = emf.createEntityManager();
				List<Message> messages = em.createQuery("select m from Message m").getResultList();
				
				assertThat(messages.size(), is(1));
				assertThat(messages.get(0).getText(), is("Hello World!"));
				
				tx1.commit();
				em.close();
			
				
			}
		} finally {
			TM.rollback();
			emf.close();
		}
		
	}
}
