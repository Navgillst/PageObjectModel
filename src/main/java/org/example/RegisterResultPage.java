package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterResultPage extends Utils
{
    //locator of text message after registration
    private By _registrationResultText = By.className("result");

    //locator of continue button
    private  By _continue = By.xpath("//a[@class=\"button-1 register-continue-button\"]");

    //storing the expected string value to variable expectedRegistrationText
    static String expectedRegistrationText  = "Your registration completed";


    //driver is waiting for URL and verifying register message is as expected
    public void verifyUserIsAbleToSeeRegisteredMessage()
    {
        //driver is waiting for URL
        waitForUrlTOBe("https://demo.nopcommerce.com/registerresult/1?returnUrl=/",10);

        String registerResulMessage =  getTextFromElement(_registrationResultText);
        System.out.println(registerResulMessage);

        //verifying register message is as expected
        Assert.assertEquals(registerResulMessage , expectedRegistrationText);

    }

    public void clickOnContinue()
    {
        //clicking on continue button
        clickOnElement(_continue);
    }
}
