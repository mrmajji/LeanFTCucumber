package com.floridablue.qa.agentpoint.pagereference;

import java.net.InetAddress;

import com.floridablue.qa.agentpoint.accelerators.PropertyReader;

public class PageHelper {
	
	public static Browser browser;
	
	PropertyReader reader;
	
	public PageHelper(){
		
		reader = new PropertyReader();
	}

	/**
	 * method is used to read browser type from property file and launch the respective browser
	 * @throws Exception
	 */
	public void launchBrowser() throws Exception{
		
		ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		InetAddress varIP = InetAddress.getLocalHost();
		String IP = varIP.toString();
		String[] strIP = IP.split("/");
		config.setServerAddress(new URI("ws://" + strIP[1] + ":5095"));
		SDK.init(config);		   
	    Reporter.init();
	    
	    String browserType = reader.readProperty("browser");
	    
	    if(browserType.equals("ie")){
	    	
	    	try{
	    		
	    		browser = BrowserFactory.launch(BrowserType.INTERNET_EXPLORER);
	    	}
	    	
	    	catch(Exception e){
	    		
	    		try{
	    			
	    			browser = BrowserFactory.launch(BrowserType.INTERNET_EXPLORER);
	    		}
	    		
	    		catch(Exception e1){
	    			
	    			browser = BrowserFactory.launch(BrowserType.INTERNET_EXPLORER);
	    		}
	    	}
	    	
	    	Thread.sleep(10000);
	    	browser.sync();
	    		
	    }
	    
	    else if(browserType.equals("firefox")){
	    	
	    	browser = BrowserFactory.launch(BrowserType.FIREFOX);
	    }
	    
	    
	    else if(browserType.equals("chrome")){
	    	
	    	browser = BrowserFactory.launch(BrowserType.CHROME);
	    }
	    
	}
	
	public void navigateToURL() {
		
		browser.sync();
		browser.navigate(reader.readProperty("url"));
		browser.sync();
	}
}
