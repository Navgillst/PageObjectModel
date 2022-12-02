package org.example;

import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class FacebookPage extends Utils
{
    public void newTab()
    {
        //storing the current window handle in variable to mainWindowHandle
        String mainWindowHandle = driver.getWindowHandle();

        //setting the string list of all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();
        //iterating all window handles
        Iterator<String> iterator = allWindowHandles.iterator();
        //while loop will execute until list have next window handles
        while (iterator.hasNext())
        {
            //next window handle storing in childWindow
            String childWindow = iterator.next();
            //checking if mainWindowHandle not equal childWindow  Handle
            if(!mainWindowHandle.equalsIgnoreCase(childWindow));
            //then switching the windowHandle to childWindowHandle
            driver.switchTo().window(childWindow);

        }

        //wait for URL to be
        waitForUrlTOBe("https://www.facebook.com/nopCommerce",10);

        //verifying if driver is on new tab
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/nopCommerce", "Right URL");

        //closing the new tab
        driver.close();

        //switching the handle back to mainWindowHandle
        driver.switchTo().window(mainWindowHandle);






    }

}
