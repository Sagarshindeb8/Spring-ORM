package com.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@Column(name = "question_Id")
	private int questionId;
	private String question;	
	
	@OneToMany(mappedBy = "question")
	private List<Answer> answers;	
	

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}


	public Question(int questionId, String question, List<Answer> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}

	public int getQuestionId() {
		return questionId;
	}	

	public String getQuestion() {
		return question;
	}

	public void setQuestionId(int questionId) {
		// TODO Auto-generated method stub
		this.questionId = questionId;
	}

	public void setQuestion(String question) {
		// TODO Auto-generated method stub
		this.question = question;
	}	
	
	
}
