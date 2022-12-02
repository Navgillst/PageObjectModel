package org.example;

import org.openqa.selenium.By;

public class AppleMacBookProPage extends Utils
{
    //emailafriend button locator
    private By _emailAFriendButton = By.className("email-a-friend");

    //Friends email field locator
    private By _friendsEmail = By.id("FriendEmail");

    //Personal message field locator
    private By _personalMessage = By.id("PersonalMessage");

    //send mail button locator
    private By _sendMail = By.className("buttons");
    public void emailAFriend()
    {
        //Navigates to the 'email a friend' page with its locator by class name using user defined method 'clickOnElement' and performing click action
        clickOnElement(_emailAFriendButton);

        //Navigates to 'friend email' field with its locator by id using user defined method 'enterText' and adding friends email id
        typeText(_friendsEmail,LoadProp.getProperty("friendsEmail"));

        //Navigates to 'your email address' field with its locator by id using user defined method 'enterText' and adding my email id
        //typeText(By.id("YourEmailAddress"),"navgillst@gmail.com");

        //Navigates to 'personal message' field with its locator by id using user defined method 'enterText' and adding message
        typeText(_personalMessage,LoadProp.getProperty("personalMessage"));

        //Navigates to the send mail with its locator by classname clicking on the button 'send mail'
        clickOnElement(_sendMail);

    }


}
