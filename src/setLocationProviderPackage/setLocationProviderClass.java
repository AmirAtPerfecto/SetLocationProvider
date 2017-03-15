package setLocationProviderPackage;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class setLocationProviderClass {
	RemoteWebDriver driver;

	// Create Remote WebDriver based on testng.xml configuration
	@Parameters({ "deviceName" })
	@BeforeTest
	public void beforeTest(String deviceName) throws IOException {
        String browserName = "mobileOS";
        DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
        String host = System.getenv().get("PERFECTO_CLOUD");
        capabilities.setCapability("user", System.getenv().get("PERFECTO_CLOUD_USERNAME"));
        capabilities.setCapability("password", System.getenv().get("PERFECTO_CLOUD_PASSWORD"));

        //TODO: Change your device ID
        capabilities.setCapability("deviceName", deviceName);

        // Use the automationName capability to define the required framework - Appium (this is the default) or PerfectoMobile.
        capabilities.setCapability("automationName", "Appium");

        // Call this method if you want the script to share the devices with the Perfecto Lab plugin.
        PerfectoLabUtils.setExecutionIdCapability(capabilities, host);
        driver = new AndroidDriver(new URL("https://" + host + "/nexperience/perfectomobile/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	} 
  @Test
  public void testLocationSettings() throws InterruptedException {
	  // go home and show settings
	  PerfectoUtils.home(driver);
	  Thread.sleep(5000);	  
	  PerfectoUtils.swipe(driver, "50%", "2%", "50%", "85%");
	  PerfectoUtils.screenshot(driver);
	  Thread.sleep(5000);	  

	  // disable location services
	  locationSetting.allOff(driver);
	  Thread.sleep(5000);
	  PerfectoUtils.screenshot(driver);
	  
	  // enable location services
	  locationSetting.allOn(driver);
	  Thread.sleep(5000);
	  PerfectoUtils.ocrTextClick(driver, "agree", 99, 20);

	  // go home and show settings
	  PerfectoUtils.home(driver);
	  Thread.sleep(5000);	  
	  PerfectoUtils.swipe(driver, "50%", "2%", "50%", "85%");
	  PerfectoUtils.screenshot(driver);
	  
  }

	@AfterTest
	public void afterTest() throws IOException {
		String reportURL = (String)driver.getCapabilities().getCapability("testGridReportUrl");
		System.out.println("########### ========>>>>>>>> Report URL: "+ reportURL); 
		// Abort test in case of an unexpected error.
		driver.close();
		driver.quit();	

	}	

}
