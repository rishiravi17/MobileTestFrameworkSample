package stepdefinitions;

import java.io.IOException;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilites.common.BaseTasks;

public class Hooks extends BaseTasks {
	
	@Before (value = "@TestFeature")
	public void initializeServer() {
		
		System.out.println("Starting Appium Server.");
		
		startAppiumServerCommand();
		
	}
	
	@After (value = "@TestFeature")
	public void tearDown() {
		
		stopAppiumServer();
		
		sleepTime(3000);
		
		try {
			
			Runtime.getRuntime().exec("cmd /c taskkill /F /IM cmd.exe");
			
			sleepTime(5000);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
