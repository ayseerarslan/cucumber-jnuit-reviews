package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/*
This class will be storing only the utility methods that can be used across the project.
 */
public class BrowserUtils {

    /*
   This method will accept int (in seconds)
   and execute Thread.sleep method for given duration
   Arg: int second
    */
    public static void sleep(int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){

        for (String each : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(each);

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));

    }

    public static void verifyTitleEquals(String expectedTitle){

        Assert.assertTrue(Driver.getDriver().getTitle().equals(expectedTitle));

    }

    public static void verifyTitleContains(String expectedTitle){

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));

    }

    /*
      This method accepts WebElement target,
      and waits for that WebElement not to be displayed on the page
       */
    public static void waitForInvisibilityOf(WebElement target){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /*
    This method accepts String title,
    and waits for that Title to contain given String value.
     */
    public static void waitForTitleContains(String title){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));
    }

    /**
     * This method accepts a dropdown element and returns a List<String> that contains all options values as String.
     * @param dropdownElement
     * @return actualMonth_as_STRING
     */

    public static List<String> dropdownOptions_as_String(WebElement dropdownElement){

        Select select = new Select(dropdownElement);
        //Storing all the ACTUAL options into a List of WebElements
        List<WebElement> actualMonth_as_WebElement = select.getOptions();

        //Creating an EMPTY list of String to store ACTUAL <option> as String
        List<String> actualMonth_as_String = new ArrayList<>();

        //Looping through the List<WebElement>, getting all options' texts and storing them into Lsit<String>
        for (int i = 0; i < actualMonth_as_WebElement.size(); i++) {
            actualMonth_as_String.add(actualMonth_as_WebElement.get(i).getText());
        }

        return actualMonth_as_String;


    }

}


