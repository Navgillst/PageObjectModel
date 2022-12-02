package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CameraAndPhotoPage extends Utils
{
    private By _productTitle = By.xpath("//h2[@class=\"product-title\"]");

    public void productNames() {
        List<WebElement> productNameList = driver.findElements(_productTitle);

        for (WebElement element : productNameList) {
            System.out.println(element.getText());

        }


    }

//    public void addToCart()
//    {
//        List<WebElement> listOfProducts = driver.findElements(By.xpath("//div[@class=\"details\"]"));
//
//
//
//                for (WebElement element: listOfProducts)
//                {
////
//                    SoftAssert softAssert = new SoftAssert();
//                    softAssert.assertTrue(element.getText().contains("ADD TO CART"));
//                    if (!element.getText().contains("ADD TO CART"))
//                    {
//
//                        System.out.println("\nADD To Cart Missing In Product :- \n "+element.getText());
//
//                    }
//}
//}


    public void addTocartButtoncheck()
    {
        By _itemBoxesfield=By.className("product-item");
        By _productNameField=By.className("product-title");

        List<String> noAddToCartButtonProducts = new ArrayList<String>();
        List<WebElement> webElementList=driver.findElements(_itemBoxesfield);
        System.out.println(webElementList.size());
        int count=0;
        for (WebElement element : webElementList)
        {
            if (element.getText().contains("ADD TO CART"))

            {
                count++;

            }
            else
            {
                noAddToCartButtonProducts.add("NO add to cart Button:"+element.findElement(_productNameField).getText());
            }
        }
        Assert.assertEquals(count,webElementList.size(),"One or more products missing add to card button\n"+noAddToCartButtonProducts);

    }
}
