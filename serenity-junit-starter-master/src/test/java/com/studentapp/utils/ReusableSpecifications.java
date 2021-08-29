package com.studentapp.utils;

import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.index.qual.LessThan;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import static org.hamcrest.Matchers.*;

public class ReusableSpecifications {
	
	//requestSpecification object set of predefined conditions before sending a req
	//responseSpecification object set of predefined conditions use to validate certain criteria in response
	public static RequestSpecBuilder rspec;
	public static RequestSpecification requestSpecification;
	public static ResponseSpecBuilder respec;
	public static ResponseSpecification responseSpecification;
	
	public static RequestSpecification getGenericRequestSpec() {
		rspec = new RequestSpecBuilder();
		rspec.setContentType(ContentType.JSON);
		requestSpecification = rspec.build();
		
		return requestSpecification;		
	}
	
	
	public static ResponseSpecification getGenericResponseSpec() {
		respec = new ResponseSpecBuilder();
		respec.expectHeader("Content-Type", "application/json;charset=UTF-8");
		respec.expectHeader("Transfer-Encoding", "chunked");
		respec.expectResponseTime(lessThan(5L),TimeUnit.SECONDS);
		responseSpecification = respec.build();
		return responseSpecification;
	}
}
