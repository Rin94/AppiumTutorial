package jaredsalinasAppium.AppiumQA;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utilities.GlobalVariables;



public class AppiumBasics {
	
	
	
	
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException {
		
		//code to start server
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File (GlobalVariables.APPIUM_PATH)).
				withIPAddress("127.0.0.1").usingPort(4723).build(); 
		
		service.start();
		
		//Create AndroidDriver object, iOSDriver
		//Appium code -> Appium Server - > Mobile
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("JaredSalinasEmulator");
		options.setApp(GlobalVariables.ECLIPSE_PATH+GlobalVariables.APP_PATH);
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.quit();		
		
		
		// stop the service
		service.stop();
		
	}

}
