package setLocationProviderPackage;

import org.openqa.selenium.remote.RemoteWebDriver;

public final class locationSetting {


	public static void gpsOn(RemoteWebDriver driver ) {
		PerfectoUtils.sendADBCommand(driver, "settings put secure location_providers_allowed +gps");
	}
	public static void gpsOff(RemoteWebDriver driver ) {
		PerfectoUtils.sendADBCommand(driver, "settings put secure location_providers_allowed -gps");
	}

	public static void networkOn(RemoteWebDriver driver ) {
		PerfectoUtils.sendADBCommand(driver, "settings put secure location_providers_allowed +network");
	}
	public static void networkOff(RemoteWebDriver driver ) {
		PerfectoUtils.sendADBCommand(driver, "settings put secure location_providers_allowed -network");
	}
	public static void allOn(RemoteWebDriver driver ) {
		gpsOn(driver);
		networkOn(driver);
	}
	public static void allOff(RemoteWebDriver driver ) {
		gpsOff(driver);
		networkOff(driver);
	}
	
}

