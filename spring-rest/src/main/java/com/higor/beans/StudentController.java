package com.higor.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.higor.pojo.College;
import com.higor.pojo.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping( path = {"/{studentId}", "/"})
	public List<Student> getStudents( @PathVariable("studentId") int studentId, HttpServletRequest request){
		
		List<Student> students =  new ArrayList<>();
		System.out.println("pesquisou pelo student : " + studentId +  " mas eu vou é devolver tudo MUAHAHAHA");
		Student student = new Student(11, "Carlos");
		student.setCollege(new College());
		student.setLanguages(Arrays.asList("English", "Portugueses"));
		
		students.add(student);
		students.add(new Student(10, "Higor"));
		students.add(new Student(12, "Alana"));
		students.add(new Student(13, "José"));
		return students;
	}
	
}
