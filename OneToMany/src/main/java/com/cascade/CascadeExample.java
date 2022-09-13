package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Question q1 = new Question();
		
		q1.setQuestionId(567);
		q1.setQuestion("What is Cascading?");
		
		Answer a1 = new Answer(2212, "It is imp");
		Answer a2 = new Answer(352, "Second answer");
		Answer a3 = new Answer(452, "Third answer");
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		Transaction tx = s.beginTransaction();
			
		s.save(q1);
		
		tx.commit();
		s.close();
		factory.close();
	}

}
