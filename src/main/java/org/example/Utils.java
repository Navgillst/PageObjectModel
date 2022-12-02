package org.example;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class Utils extends BasePage
{
    //Reusable method clickOnElement() for clicking on element
    public static void clickOnElement(By by)

    {
        //To 'findElement' with object(driver) of its class and to perform click action
        driver.findElement(by).click();
    }

    //Reusable method typeText() for entering the text in string format
    public static void typeText(By by,String text)
    {
        //To 'findElement' with object(driver) of its class and to perform senKeys action to enter text
        driver.findElement(by).sendKeys(text);
    }

    //Reusable method getTextFromElement() for getting the text from element
    public static String getTextFromElement(By by)
    {

        //To 'findElement' with object(driver) of its class and to perform getText action to get the string value
        return driver.findElement(by).getText();

    }

    //Reusable method getTimeStamp() for time stamp
    public static String getTimeStamp()
    {
        //storing current year month  date hour minute and seconds in variable timeStamp
        return  new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

    }

    //Reusable method waitForElementToBeClickable() for driver to wait for until particular element is clicked
    public static void waitForElementToBeClickable(By by,int duration)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    //Reusable method waitForElementToBeVisible() for driver to wait for until particular element is visible
    public static void waitForElementToBeVisible(By by, int duration)
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    //Reusable method waitForUrlTOBe() for driver to wait for URL explicitly
    public static void waitForUrlTOBe(String url, int duration)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.urlToBe(url));

    }



    //Reusable method selectFromDropDownByVisibleText() for select the element by its visible text
    public static void selectFromDropDownByVisibleText(By by, String txt)
    {
        //Using select class with its object to select the day using findElement function
        Select text = new Select(driver.findElement(by));
        // To select day using selectByVisibleText function
        text.selectByVisibleText(txt);
    }

    //Reusable method selectFromDropDownByValue() for select the element by its value
    public static void selectFromDropDownByValue(By by, String value)
    {

        //Using select class with its object to select the month using findElement function
        Select selectValue = new Select(driver.findElement(by));
        // To select Month  using selectByValue function
        selectValue.selectByValue(value);
    }

    //Reusable method selectFromDropDownByIndex() for select the element by index
    public static void selectFromDropDownByIndex(By by, int index)
    {

        //Using select class with its object to select the month using findElement function
        Select selectIndex = new Select(driver.findElement(by));
        // To select year using selectByIndex function
        selectIndex.selectByIndex(index);
    }

    public static void captureScreenShot(String screenshotSource)
    {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File SrcFile=screenshot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("src/ScreenShots"+screenshotSource+getTimeStamp()+".jpg");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
