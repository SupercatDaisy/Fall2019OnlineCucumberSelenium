package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.PageBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.Wait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String URL = ConfigurationReader.getProperty("qa3");
        Driver.getDriver(ConfigurationReader.getProperty("browser")).get(URL);

    }

    @When("user logs in as a sales manager")
    public void user_logs_in_as_a_sales_manager() {
        loginPage.login("salesmanager110", "UserUser123", false);

    }

    @When("user logs in as a store manager")
    public void userLogsInAsAStoreManager() {
        loginPage.login("storemanager85", "UserUser123", false);
    }

    @Then("user should verify that title is a Dashboard")
    public void user_should_verify_that_title_is_a_Dashboard() {
        Assert.assertEquals("Dashboar", Driver.getDriver(ConfigurationReader.getProperty("browser")).getTitle());
    }

    @When("user logs in as a driver")
    public void user_logs_in_as_a_driver() {
        loginPage.login("user19", "UserUser123", false);
        Wait.wait(2);
    }

    @When("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String string, String string2) {
        System.out.printf("Login with user name %s and %s password",string,string2);
      loginPage.login(string,string2,false);
    }


    @Then("user name should be {string}")
    public void userNameShouldBe(String name) {
        Assert.assertEquals(loginPage.getCurrentUserName(),name);

    }

    @When("user logs in as {string}")
    public void user_logs_in_as(String string) {
        loginPage.login(string);
    }

    @Then("user verifies that page title is {string}")
    public void user_verifies_that_page_title_is(String string) {
       Assert.assertEquals(string,Driver.getDriver(ConfigurationReader.getProperty("browser")).getTitle());
    }

}