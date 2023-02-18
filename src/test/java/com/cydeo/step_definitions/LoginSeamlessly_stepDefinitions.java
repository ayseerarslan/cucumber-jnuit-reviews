package com.cydeo.step_definitions;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSeamlessly_stepDefinitions {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("seamless.url"));
    }
    @When("the user enters valid username")
    public void the_user_enters_valid_username() {

    }
    @When("the user enters valid password")
    public void the_user_enters_valid_password() {

    }
    @When("the user clicks the login in button")
    public void the_user_clicks_the_login_in_button() {

    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {

    }
}
