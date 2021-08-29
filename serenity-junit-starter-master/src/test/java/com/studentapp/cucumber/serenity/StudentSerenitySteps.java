package com.studentapp.cucumber.serenity;

import java.util.HashMap;
import java.util.List;

import com.studentapp.model.StudentClass;
import com.studentapp.utils.ReusableSpecifications;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StudentSerenitySteps {
	@Step("This test will create a student with firstName {0} lastName {1} emailId {2} Programme {3} Courses {4}")
	public ValidatableResponse createStudent(String firstName, String lastName, String email, 
			String programme, List<String> courses) {

		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);

		return SerenityRest.rest().given()
				.spec(ReusableSpecifications.getGenericRequestSpec())
				.when()
				.body(student)
				.post()
				.then();

	}
	@Step("This test will get the student having firstName {0}")
	public HashMap<String, Object> getStudentInfoByFirstname(String firstName){
		String p1 = "findAll{it.firstName=='";
		String p2 =	"'}.get(0)";

		return  SerenityRest.rest().given()
				.when()
				.get("/list")
				.then()
				.log()
				.all()
				.statusCode(200)
				.extract()
				.path(p1+firstName+p2);

	}
	@Step("Updating student information with studentId {0} firstName {1} lastName {2} emailId {3} Programme {4} Courses {5}")
	public ValidatableResponse updateStudent(int studentId, String firstName, String lastName, String email, 
			String programme, List<String> courses) {

		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);

		return SerenityRest.rest().given().spec(ReusableSpecifications.getGenericRequestSpec()).log().all()
				.when()
				.body(student)
				.put("/"+studentId )
				.then();

	}
	@Step("Deleting student information with Id: studentId {0}")
	public void deleteStudent(int studentId) {
		SerenityRest.rest().given().when().delete("/" + studentId);
	}
	@Step("Validating that studentId {0} is deleted or not")
	public ValidatableResponse verifyStudentDeletion(int studentId) {
		return SerenityRest.rest().given().when().get("/" + studentId)
		.then();
	}

}
