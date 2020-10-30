package com.higor.simple;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.higor.pojo.Student;

public class Driver {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		
		try {
			Student studentToWrite = new Student(10, "Alana");		
			
			//Writing JSON to output file
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			mapper.writeValue(new File("data/jsons/student2.json"), studentToWrite);

			//Read a JSON from file and convert to POJO
			Student student = mapper.readValue(new File("data/jsons/student.json"), Student.class);			
			System.out.println(student);
			

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
