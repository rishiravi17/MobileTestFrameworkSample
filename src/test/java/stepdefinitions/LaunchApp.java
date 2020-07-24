package stepdefinitions;

import org.junit.runner.RunWith;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilites.common.BaseTasks;
import utilites.common.MobileApps;

@RunWith(Cucumber.class)
public class LaunchApp extends BaseTasks {

	private MobileApps apps;

	private String appPackageName;
	
	private AndroidDriver<AndroidElement> driver;
	
	{
		
		initializeObjects();
		
	}
	
	public void initializeObjects() {
		
		driver = getAndroidDriver();

		apps = new MobileApps(driver);
		
	}

	@Given("^Launch \"([^\"]*)\" app$")
	public void launch_something_app(String appName) {		

		if (appName.equalsIgnoreCase("gmail")) {			

			appPackageName = apps.launchGmail();

		} else if (appName.equalsIgnoreCase("playstore")) {

			appPackageName = apps.launchPlayStore();

		}

	}

	@Then("^Wait for some a few seconds \"([^\"]*)\"$")
	public void wait_for_some_a_few_seconds_something(String timeToWait) {

		sleepTime(Integer.parseInt(timeToWait));

	}

	@And("^Close the app$")
	public void close_the_app() {

		System.out.println("Closing the app");
		
		driver.terminateApp(appPackageName);

	}

}
