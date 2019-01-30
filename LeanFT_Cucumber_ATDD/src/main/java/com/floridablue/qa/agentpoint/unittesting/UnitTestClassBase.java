package com.floridablue.qa.agentpoint.unittesting;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.TestWatcher;

public class UnitTestClassBase extends UnitTestBase {
	
	protected static UnitTestClassBase instance;
	protected static String className;
	protected String testName;
	
	public static void globalSetup(Class<? extends UnitTestClassBase> testClass) throws Exception{
		
		if(instance == null)
			instance = testClass.newInstance();
		instance.classSetup(); 
	}
	
	public static void globalTearDown() throws Exception {
		
		instance.classTearDown();
		getReporter().generateReport();
	}
	
	@ClassRule
	public static TestWatcher classWatcher = new TestWatcher(){
		
		@Override
		protected void starting(org.junit.runner.Description description){
			
			className = description.getClassName();
		}
	};
	
	@Rule
	public TestWatcher watcher = new TestWatcher() {
		
		@Override
		protected void starting(org.junit.runner.Description description){
			
			testName = description.getMethodName();
		}
		
		@Override
		protected void failed(Throwable e, org.junit.runner.Description description){
			setStatus(Status.Failed);
		}
		
		@Override
		protected void succeeded(org.junit.runner.Description description){
			setStatus(Status.Passed);
		}
		
	};
	
	@Override
	protected String getTestName(){
		
		return testName;
	}
	
	@Override
	protected String getClassName(){
		
		return className;
	}

}
