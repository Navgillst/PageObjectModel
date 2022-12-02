package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class DriverManager extends Utils
{
    public static final String USERNAME = LoadProp.getProperty("BROWSER_USERNAME");
    public static final String AUTOMATE_KEY = LoadProp.getProperty("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    //String browserName = LoadProp.getProperty("browser");
    //    String browserName = System.getProperty("browser");
    // boolean runInCloud = Boolean.parseBoolean(System.getProperty("cloud"));
    boolean runInCloud = Boolean.parseBoolean(LoadProp.getProperty("cloud"));

    MutableCapabilities capabilities = new MutableCapabilities();

    String browserName = LoadProp.getProperty("browser");



    public void openBrowser()
    {
        //run in cloud ----------------------------------------------------------------------====
        if (runInCloud)
        {
            //connect to cloud
            System.out.println("Running in the Cloud");
            if (browserName.equalsIgnoreCase("Edge")) {
                ///connect with browserstack
                capabilities.setCapability("browserName", "Edge");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);

            } else if (browserName.equalsIgnoreCase("Firefox"))
            {
                ///connect with browserstack
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "11");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);
            } else {
                System.out.println("Your browser name is wrong or missing implementation:" + browserName);
            }
            try {
                driver = new RemoteWebDriver(new URL(URL), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            //run in locally
            System.out.println("Running Locally");

            if (browserName.equalsIgnoreCase("Chrome")) {
                //set driver path for Chrome browser
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
                //opening Chrome browser
                driver = new ChromeDriver();

            } else if (browserName.equalsIgnoreCase("Edge")) {
                //set driver path for Chrome browser
                System.setProperty("webdriver.edge.driver", "src/test/java/drivers/msedgedriver.exe");
                //opening Chrome browser
                driver = new EdgeDriver();

            } else if (browserName.equalsIgnoreCase("Firefox")) {
                //set driver path for Chrome browser
                System.setProperty("webdriver.gecko.driver", "src\\test\\java\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();

            } else {
                System.out.println("Yor browser name is wrong or missing implementation" + browserName);
            }
        }



        //Navigating to demo.nopcommerce.com website with get() method through the object driver
        driver. get(LoadProp.getProperty("url"));
        //Keeping the browser in full screen mode
        driver.manage().window().maximize();




    }




    //To close browser
    public void closeBrowser()

    {
        //To close browser
        driver.quit();
    }


}


