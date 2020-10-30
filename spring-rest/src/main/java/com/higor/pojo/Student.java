package com.higor.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

	private Integer id;
	private String nome;
	private College college;
	private List<String> languages;
	
	public Student(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Student() {
		super();
	}

	@Override
	public String toString() {
		String toString = id + " " + nome;
		
		if(college != null) {
			toString += " college: " + college.getName();
		}
		
		if(languages != null) {
			toString += " languages: " + languages.toString();
		}
		
		return toString;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}
}
