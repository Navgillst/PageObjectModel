package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils
{

    DriverManager driverManager = new DriverManager();
    HomePage homePage = new HomePage();

    //Creating Object of RegistrationPage
    RegistrationPage registrationPage=new RegistrationPage();

    //Creating Object of RegisterResultPage
    RegisterResultPage registerResultPage = new RegisterResultPage();

    //Creating Object of ElectronicsPage
    ElectronicsPage electronicsPage = new ElectronicsPage();

    //Creating Object of CameraAndPhotoPage
    CameraAndPhotoPage cameraAndPhotoPage = new CameraAndPhotoPage();

    //Creating Object of NewReleaseCommentPage
    NewReleaseCommentPage newReleaseCommentPage = new NewReleaseCommentPage();

    //Creating object of facebookPage
    FacebookPage facebookPage = new FacebookPage();

    //Creating object of AppleMacBookProPage
    AppleMacBookProPage appleMacBookProPage = new AppleMacBookProPage();

    //Creating object of ProductEmailAFriend
    ProductEmailAFriendPage productEmailAFriendPage = new ProductEmailAFriendPage();

    //Creating the object of NikePage
    NikePage nikePage = new NikePage();


    //Before Method Annotation will execute this method before executing any other method
    @BeforeMethod
    public void setUp()
    {
        //openBrowser method is called with object
        driverManager. openBrowser();

    }

    //AfterMethod Annotation will execute this method after executing any other method
    @AfterMethod

    public void tearDown(ITestResult result)
    {
        //condition to check if test fails
        if(!result.isSuccess())
        {
            //calling captureScreenShot Method
            captureScreenShot(result.getName());
        }
        //closeBrowser method is called with object
        driverManager.closeBrowser();

    }

}


