package com.floridablue.qa.agentpoint.runner;

import org.junit.runner.RunWith;

import com.floridablue.qa.agentpoint.unittesting.UnitTestClassBase;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "target/classes/Feature/Regression",
        glue = "com/floridablue/qa/agentpoint/stepdefinition",
        tags="@regression",
        plugin = {"json:target/cucumber-report.json", 
        "html:target/cucumber-report"}) 

public class LeanFTRunner extends UnitTestClassBase{
	
	public LeanFTRunner(){
		
		//Constructor
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		instance = new LeanFTRunner();
		globalSetup(LeanFTRunner.class);
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		
	}
}


