package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Creating question
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java?");
		
		//Creating answer
		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("Java is a programming language");
		answer.setQuestion(q1);
		q1.setAnswer(answer);
		
		//Creating question
		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What is collection framework?");
		
		//Creating answer
		Answer answer1 = new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("API to work with objects in java");
		answer1.setQuestion(q2);
		q2.setAnswer(answer1);
		
		//session		
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		//Save
		s.save(q1);
		s.save(q2);
		s.save(answer);
		s.save(answer1);
		
		tx.commit();	
		
		//fetching question and answer
		Question q = s.get(Question.class,1212);
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswer().getAnswer());
		
		factory.close();

	}

}
