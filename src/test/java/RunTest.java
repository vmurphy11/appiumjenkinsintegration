import static org.junit.Assert.*;

import org.junit.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class RunTest {
	@Test
	public  void test ()	throws MalformedURLException, InterruptedException
	
	{
		
	DesiredCapabilities capabilities=new DesiredCapabilities();

	capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.IOS_XCUI_TEST);

	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,System.getProperty("PlatformName"));

	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,System.getProperty("PlatformVersion"));
 	capabilities.setCapability(MobileCapabilityType.APP,"/Users/vmurphy/Desktop/UICatalog.app");

	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 6");

	capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6.4");
	IOSDriver driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	capabilities.setCapability("noReset",false);
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
  

   // MobileElement ele2 = (MobileElement) driver.findElementByIosNsPredicate("name = 'Segmented Controls'");    
   // ele2.click();
   /* JavascriptExecutor js = (JavascriptExecutor) driver;
    Map<String, Object> params = new HashMap<>();
    params.put("direction", "down");
    js.executeScript("mobile: scroll", params);
    */
    MobileElement ele2 = (MobileElement) driver.findElementByIosNsPredicate("name = 'Alert Views'");
    ele2.click();
  //  List  list=driver.findElements(By.className("XCUIElementTypeSegmentedControl"));
  //  System.out.println("Size of list: " + list.size());
  //  MobileElement ele3 = (MobileElement) (list.get(0));
    MobileElement ele4=(MobileElement) driver.findElementByIosNsPredicate("name = 'Simple'");
    ele4.click();
    //ele4.click();
    //ele4.sendKeys("7");
  /*  Alert alert =driver.switchTo().alert();
    alert.accept();*/ 
    //above works but trying different way
   
    WebElement ele5=driver.findElement(By.className("XCUIElementTypeAlert"));
    if (ele5.getAttribute("name").contentEquals("A Short Title Is Best"))
    		{
    	     driver.findElementByIosNsPredicate("name = 'OK'").click();
    	
    	
    		}
    
    Thread.sleep(7000);

	driver.quit();

}
}

