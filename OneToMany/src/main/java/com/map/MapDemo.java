package com.map;

import java.util.ArrayList;
import java.util.List;

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
		Question q1 = new Question();/*
		q1.setQuestionId(121);
		q1.setQuestion("What is Java");
		
		//Creating answer*/
		Answer answer = new Answer();/*
		answer.setAnswerId(30);
		answer.setAnswer("Java is a programming language");
		answer.setQuestion(q1);*/
		
		Answer answer1 = new Answer();/*
		answer1.setAnswerId(33);
		answer1.setAnswer("With the help of java we can create software");
		answer1.setQuestion(q1);*/

		Answer answer2 = new Answer();/*
		answer2.setAnswerId(36);
		answer2.setAnswer("Java has various frameworks");
		answer2.setQuestion(q1);*/
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		q1.setAnswers(list);
		
		//session		
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		/*
		//save
		s.save(q1);
		s.save(answer);
		s.save(answer1);
		s.save(answer2);
		*/
			
		
		
		//fetching question and answer
		Question q = (Question) s.get(Question.class,121);
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		
		System.out.println(q.getAnswers());
		//System.out.println(q.getAnswers().size());
		
		/*
		for(Answer a:q.getAnswers())
		{
			System.out.println(a.getAnswer());
		}
		*/
		tx.commit();
		s.close();
		factory.close();

	}

}
