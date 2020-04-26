package com.vytrack.step_definitions;

import com.vytrack.pages.Activities.CalendarEventPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.Wait;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class CalendarEventStepDefinition {
    LoginPage loginPage=new LoginPage();
    CalendarEventPage calendarEventPage=new CalendarEventPage();

    @When("user navigates to {string} and {string}")
    public void user_navigates_to_and(String tab, String module) {
    loginPage.navigateTo(tab,module);
    }


    @Then("user click on create calendar event button")
    public void user_click_on_create_calendar_event_button() {
        calendarEventPage.clickToCreateEvent();
    }

    @Then("user enters {string} as a title")
    public void user_enters_as_a_title(String string) {
        calendarEventPage.enterCalendarEventTitle(string);
    }

    @Then("user enters {string} as description")
    public void user_enters_as_description(String string) {
        calendarEventPage.enterCalendarEventDescription(string);
    }

    @Then("user click on save and close button")
    public void user_click_on_save_and_close_button() {
        calendarEventPage.clickOnSaveAndClose();
    }

    @Then("user verify that description is {string}")
    public void user_verify_that_description_is(String string) {
       Assert.assertEquals(string,calendarEventPage.getGeneralInfoDescriptionText());
    }

    @Then("user verify that title is {string}")
    public void user_verify_that_title_is(String string) {
       Assert.assertEquals(string,calendarEventPage.getGeneralInfoTitleText());
}
    @Then("user enters new calendar event information")
    public void user_enters_new_calendar_event_information(Map<String,String> dataTable) {
        calendarEventPage.enterCalendarEventTitle(dataTable.get("title"));
        calendarEventPage.enterCalendarEventDescription(dataTable.get("description"));


    }

    @Then("user verifies that new calendar event was created")
    public void user_verifies_that_new_calendar_event_was_created(Map<String,String> dataTable) {
    Assert.assertEquals(dataTable.get("description"),calendarEventPage.getGeneralInfoDescriptionText());
    Assert.assertEquals(dataTable.get("title"),calendarEventPage.getGeneralInfoTitleText());

    }
}
