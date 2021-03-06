package com.studentapp.junit.studentsinfo;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase{
	
	@WithTag("studentfeature:NEGATIVE")
	@Title("Provide a 405 status code in case of incorrect http method is used to access a resource")
	@Test
	public void inValidMethod() {
		SerenityRest.rest().given()
		.when()
		.post("/list")
		.then()
		.statusCode(405)
		.log()
		.all();		
	}
	@WithTags ({
		@WithTag("studentfeature:NEGATIVE"),
		@WithTag("studentfeature:SMOKE")}
	)
	@Title("This test will verify wether 200 is return in case of get request")
	@Test
	public void verifyTheStatusCodeIs200() {
		SerenityRest.rest().given()
		.when()
		.get("/list")
		.then()
		.statusCode(200);		
	}
	@WithTags ({
		@WithTag("studentfeature:NEGATIVE"),
		@WithTag("studentfeature:SMOKE")}
	)	
	@Title("This test will provide 400 when user try to access invalid resource")
	@Test
	public void incorrectResource() {
		SerenityRest.rest().given()
		.when()
		.get("/listdd")
		.then()
		.statusCode(400);		
	}

}
