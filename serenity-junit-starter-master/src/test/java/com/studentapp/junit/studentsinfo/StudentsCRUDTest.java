package com.studentapp.junit.studentsinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
//import org.junit.jupiter.api.Test; 
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.BeforeClass;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.TestMethodOrder;
import org.junit.FixMethodOrder;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReusableSpecifications;
import com.studentapp.utils.TestUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SerenityRunner.class)
//@TestMethodOrder(OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentsCRUDTest extends TestBase {

	@Steps
	StudentSerenitySteps steps;
	static String firstName = "Swapnesh"+TestUtils.randomValue();
	static String lastName= "Kunjir"+TestUtils.randomValue();
	static String email= TestUtils.randomValue() + "swapnesh@gmail.com";
	static String programme = "Computer";
	static int studentId; 


	@Title("This test will create a new student into StudentApp")
	@Test
	public void test001() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Udemy Auomation API");
		courses.add("Udemy Automation UI");

		StudentSerenitySteps createStudentObj = new StudentSerenitySteps();
		/*createStudentObj.createStudent("Swapneeeefes111h","Kun1d1ee1jir", "seeee1dunji1r8@gmail.com", "MCA", courses)
		.statusCode(201);*/
		steps.createStudent(firstName, lastName, email, programme, courses)
		.statusCode(201)
		.spec(ReusableSpecifications.getGenericResponseSpec());
	}
	@Title("Verify if Student is added to the StudentAPP")
	@Test
	public void test002() {

		HashMap<String, Object> value =  steps.getStudentInfoByFirstname(firstName);
		assertThat(value, hasValue(firstName));
		studentId =  (int) value.get("id");
	}
	@Title("This test will update student information and verify the updated information")
	@Test
	public void test003() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		firstName = firstName + "_Updated";
		steps.updateStudent(studentId, firstName, lastName, email, programme, courses);
		HashMap<String, Object> value =  steps.getStudentInfoByFirstname(firstName);
		assertThat(value, hasValue(firstName));
	}
	@Title("Delete the student and verify if the student is deleted")
	@Test
	public void test004() {

		steps.deleteStudent(studentId);
		steps.verifyStudentDeletion(studentId).statusCode(404);

	}


}
