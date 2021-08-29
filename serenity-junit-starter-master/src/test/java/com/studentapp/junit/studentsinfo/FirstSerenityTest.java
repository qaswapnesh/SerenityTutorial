package com.studentapp.junit.studentsinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;


@RunWith(SerenityRunner.class)
public class FirstSerenityTest {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost:8084/student";
	}

	@Test
	public void getAllStudents() {
		RestAssured.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()	
		.statusCode(200);
	}
	@Test
	public void thisIsFailing() {
		RestAssured.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()	
		.statusCode(500);
		
	}
	@Pending
	@Test
	public void thisIsPendingTest() {
		
	}
	@Ignore
	@Test
	public void thisIsASkippedTest() {
		
	}	
	@Test
	public void thisIsAssertionWithErrorTest() {
		System.out.println("This is an Error" + (5/0));
		
	}
	@Test
	public void fileDoesNotExist() throws FileNotFoundException {
		File file = new File("/home/dummypath");
		FileReader fr = new FileReader(file);
		
	}
	@Manual
	@Test
	public void thisIsAManualTest() {
		
	}	
}
