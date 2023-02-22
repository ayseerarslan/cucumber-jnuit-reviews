package com.cydeo.step_definitions;

import com.cydeo.pages.SeamlesslyLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSeamlessly_stepDefinitions {

    SeamlesslyLoginPage seamlesslyLoginPage = new SeamlesslyLoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("seamless.url"));
    }

    @When("the user enters valid username")
    public void the_user_enters_valid_username() {
        seamlesslyLoginPage.username.sendKeys("Employee61");
    }

    @When("the user enters valid password")
    public void the_user_enters_valid_password() {
        seamlesslyLoginPage.password.sendKeys("Employee123");
    }

    @When("the user clicks the login in button")
    public void the_user_clicks_the_login_in_button() {
        seamlesslyLoginPage.logInButton.click();
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }

    @When("the user enters invalid username")
    public void theUserEntersInvalidUsername() {
        seamlesslyLoginPage.username.sendKeys("invalid1");

    }

    @And("the user enters invalid password")
    public void theUserEntersInvalidPassword() {
        seamlesslyLoginPage.password.sendKeys("invalid123");
    }

    @Then("the user should not be able to login")
    public void theUserShouldNotBeAbleToLogin() {

        String uMsg = seamlesslyLoginPage.getMsg1();
        String pMsg = seamlesslyLoginPage.getMsg2();

        Assert.assertTrue(uMsg.contains("Please fill out this field."));
        Assert.assertTrue(pMsg.contains("Please fill out this field."));


//        String pageSource = Driver.getDriver().getPageSource();
//        Assert.assertTrue(pageSource,pageSource.contains("Please fill"));
    }

    @Then("the user should not be able to login and get the error message")
    public void theUserShouldNotBeAbleToLoginAndGetTheErrorMessage() {
        String exp = "Wrong username or password.";
        String act = seamlesslyLoginPage.errorMessage.getText();

        Assert.assertTrue(exp.equals(act));

    }

    @When("the user enters username {string}")
    public void theUserEntersUsername(String username) {
        if (username.equals("empty")){
            seamlesslyLoginPage.username.sendKeys("");
        }else{
            seamlesslyLoginPage.username.sendKeys(username);
        }
    }

    @And("the user enters password {string}")
    public void theUserEntersPassword(String password) {
        if(password.equals("empty")){
            seamlesslyLoginPage.password.sendKeys("");
        }else{
            seamlesslyLoginPage.password.sendKeys(password);
        }
    }

    @Then("the user should not be able to login for all")
    public void theUserShouldNotBeAbleToLoginForAll() {
        Assert.assertEquals("Seamlessly",Driver.getDriver().getTitle());

    }
}
