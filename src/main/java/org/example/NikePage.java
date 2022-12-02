package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class NikePage extends Utils
{
    public void verifySearchFunctionality()
    {
        waitForUrlTOBe("https://demo.nopcommerce.com/search?q=Nike", 10);

        List<WebElement> productList = driver.findElements(By.className("product-title"));
        System.out.println("Product List is:");
        for (WebElement element : productList)
        {
            Assert.assertTrue(element.getText().contains("Nike"));
            System.out.println("\n" + element.getText());
        }
    }
}
