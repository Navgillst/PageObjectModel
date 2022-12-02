package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class NewReleaseCommentPage extends Utils
{
    //Comment Title locator
    private By _commentTitle = By.id("AddNewComment_CommentTitle");

    //Comment text Field locator
    private By _writeComment = By.id("AddNewComment_CommentText");

    //NEW COMMENT button locator
    private By _newCommentButton =By.xpath("//button[@name=\"add-comment\"]");

    //Message locator after adding comment
    private By _commentMessage = By.className("result");




    public void addComment()
    {
        //Navigates to 'Title' field with its locator by id using user defined method 'enterText' and adding Title
        typeText(_commentTitle,"Computer Review "+getTimeStamp());

        //Navigates to 'Comment' field with its locator by id using user defined method 'enterText' and adding Comment
        typeText(_writeComment,"It is working really well");

        //Navigates to the 'NEW COMMENT' button with its locator by xpath using user defined method 'clickOnElement'  and performing click action
        clickOnElement(_newCommentButton);

    }

    public void verifyActualCommentMessageIsEqualToExpectedCommentMessage()
    {
        //putting the text value of the string in variable commentMsg with its locator by using user defined method getTextFromElement();
        String actualCommentMsg = getTextFromElement(_commentMessage);
        //putting the expected string value to the variable
        String expectedCommentMessage = "News comment is successfully added.";

        //assert to verify actual comment message = expected comment message
        Assert.assertEquals(actualCommentMsg,expectedCommentMessage);

        //printing the value of the variable commentMsg
        System.out.println(actualCommentMsg);



    }


}
