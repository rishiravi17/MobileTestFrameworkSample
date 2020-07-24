package utilites.common;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MobileApps {
	
	private AndroidDriver<AndroidElement> driver;
	
	public MobileApps(AndroidDriver<AndroidElement> driver) {
		
		this.driver = driver;
		
	}
	
	String appPackageName = null;
	
	String appActivityName = null;
	
	public String launchGmail() {
		
		System.out.println("In launchGmail()");
		
		appPackageName = "com.google.android.gm";
		
		appActivityName = "com.google.android.gm.ConversationListActivityGmail";
		
		Activity activity = new Activity(appPackageName, appActivityName);
		
		activity.setStopApp(false);
		
		driver.startActivity(activity);
		
		System.out.println("Launched GMail");
		
		return appPackageName;
		
	}
	
	public String launchPlayStore() {
		
		appPackageName = "com.android.vending";
		
		appActivityName = "com.android.vending.AssetBrowserActivity";
		
		Activity activity = new Activity(appPackageName, appActivityName);
		
		activity.setStopApp(false);
		
		driver.startActivity(activity);
		
		System.out.println("Launched PlayStore");
		
		return appPackageName;
		
	}
	

}
