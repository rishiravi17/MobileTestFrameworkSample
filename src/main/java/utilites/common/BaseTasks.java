package utilites.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTasks {

	private AndroidDriver<AndroidElement> driver;

	public AndroidDriver<AndroidElement> getAndroidDriver() {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");

		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 150000);

		capabilities.setCapability("autoGrantPermissions", true);

		capabilities.setCapability("androidInstallTimeout", 150000);

		try {

			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

		return driver;

	}

	public AndroidDriver<AndroidElement> getDemoApp() {

		AndroidDriver<AndroidElement> demoAppDriver = null;

		File apiDemoApk = new File(System.getProperty("user.dir") + "\\APKStore\\ApiDemos-debug.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");

		capabilities.setCapability(MobileCapabilityType.APP, apiDemoApk.getAbsolutePath());

		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 150000);

		capabilities.setCapability("androidInstallTimeout", 150000);

		capabilities.setCapability("autoGrantPermissions", true);

		try {

			demoAppDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

		return demoAppDriver;

	}

	public void sleepTime(int waitTimeInSeconds) {

		try {

			Thread.sleep(waitTimeInSeconds);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	public void startAppiumServerCommand() {

		BufferedReader reader = null;

		try {

			File appiumLogFolder = new File(System.getProperty("user.dir") + "\\AppiumServerLogs\\");

			if (!appiumLogFolder.exists()) {

				System.out.println("Creating Appium Server log folder for the first time.");

				appiumLogFolder.mkdir();

			}

			File appiumLogFile = new File(System.getProperty("user.dir") + "\\AppiumServerLogs\\ServerLogs.txt");

			if (!appiumLogFile.exists()) {

				System.out.println("Creating log file for the first time.");

				appiumLogFile.createNewFile();

			}

			DateFormat dateFormat = new SimpleDateFormat("MMddyyyyhhmmss");

			Date date = new Date();

			String timeStamp = dateFormat.format(date);

			File appiumLogBackup = new File(
					System.getProperty("user.dir") + "\\AppiumServerLogs\\ServerLogs_" + timeStamp + ".txt");

			if (appiumLogFile.exists()) {

				System.out.println("Taking backup of Appium Server logs.");

				appiumLogFile.renameTo(appiumLogBackup);

				appiumLogFile.createNewFile();

			}

			Runtime.getRuntime().exec("cmd /c start StartAppiumServer.bat");

			sleepTime(5000);

			reader = new BufferedReader(new FileReader(appiumLogFile));

			ServerStarted: for (int i = 0; i < 10; i++) {

				String currentLine = reader.readLine();

				while (currentLine != null) {
					
					if (currentLine.contains("Appium REST http interface listener started on 0.0.0.0:4723")) {

						System.out.println("Server has been started.." + currentLine);

						break ServerStarted;

					}
					
					currentLine = reader.readLine();
					
				}
				
				System.out.println("Retrying - " + i);

				sleepTime(5000);

			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				reader.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

	public void stopAppiumServer() {

		try {

			Runtime.getRuntime().exec("cmd /c taskkill /F /IM node.exe");

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
