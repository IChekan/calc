package module6.week1.driverSingleton;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

/**
 * Created by Ihar_Chekan on 6/25/2015.
 */
public class AndroidDriverSingleton {

    private static AppiumDriver driver;

    private AndroidDriverSingleton() {};

    public static AppiumDriver getAndroidDriverInstance() throws Exception {
        if (null == driver) {
            File appDir = new File("D:\\Repo\\calcCopy\\target\\classes");
            File app = new File(appDir, "calc.apk");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 4 API 22");
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "module6.calc.mobile");
            capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "MyNewCalc");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "19");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }
        return driver;
    }
}
