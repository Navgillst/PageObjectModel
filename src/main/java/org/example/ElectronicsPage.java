package org.example;

import org.openqa.selenium.By;

public class ElectronicsPage extends Utils
{
    //Camera and photo locator
    private By _cameraAndPhoto = By.linkText("Camera & photo");


    public void navigateToCameraAndPhoto()

    {
        //clicking on camera and photo
        clickOnElement(_cameraAndPhoto);
    }

}
