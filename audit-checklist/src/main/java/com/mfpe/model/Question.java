package com.mfpe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue
	private int questionId;
	
	private String question;
	
	private String auditType;
	
	private char response;
	
}
