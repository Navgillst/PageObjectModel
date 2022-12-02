package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest
{
    //Test annotation to run test with using main method
    @Test
    public void registrationDetails()
    {
        //Methods from HomePage class are being called with its object
        homePage.verifyRegisterButtonIsPresent();
        homePage.clickOnRegisterButton();


        //Methods from RegistrationPage class are being called with its object
        registrationPage.verifyUserIsOnRegisterPage();
        registrationPage.register();


        //Method from RegisterResultPage class are being called with its object
        registerResultPage.verifyUserIsAbleToSeeRegisteredMessage();

    }
    //Test annotation to run test with using main method
    @Test
    public void  printingProductName()
    {
        homePage.navigateToElectronics();
        electronicsPage.navigateToCameraAndPhoto();
        cameraAndPhotoPage.productNames();
        //cameraAndPhotoPage.addToCart();
        cameraAndPhotoPage.addTocartButtoncheck();


    }

    //Test annotation to run test with using main method
    @Test
    //checking if correct currency symbol display for each product
    public void currencySymbol()
    {
        homePage.verifyCorrectCurrencySymbolDisplayIsUSD();
        homePage.verifyCorrectCurrencySymbolDisplayIsEuro();
    }

    //Test annotation to run test with using main method
    @Test
    //verifying if alert present then accepting alert
    public void handleAlert()
    {
        homePage.acceptIfAlertPresent();

    }

    //Test annotation to run test with using main method
    @Test
    //commenting on demo nopcommerce new release
    public void newReleaseComment()
    {
        homePage.clickOnNopCommerceNewReleaseDetailsButton();
        newReleaseCommentPage.addComment();
        newReleaseCommentPage.verifyActualCommentMessageIsEqualToExpectedCommentMessage();

    }


    //Test annotation to run test with using main method
    @Test
    public void facebook()
    {
        //clicking on facebook logo
        homePage.facebookLogo();
        //giving handle to new tab and bring the handle back
        facebookPage.newTab();
    }


    //Test annotation to run test with using main method
    @Test
    //Referring Apple MacBook pro 13-inch to a friend
    public void referProductToAFriend()
    {
        homePage.clickOnRegisterButton();

        registrationPage.register();

        registerResultPage.verifyUserIsAbleToSeeRegisteredMessage();

        registerResultPage.clickOnContinue();

        homePage.clickOnAppleMacBookPro();

        appleMacBookProPage.emailAFriend();

        productEmailAFriendPage.verifyEmailMessage();

    }

    @Test
    public void hoverFunctionality()
    {
        homePage.hoverActionComputer();
    }

    @Test
    public void searchFunctionality()
    {
        homePage.searchBar();
        nikePage.verifySearchFunctionality();
    }


}



