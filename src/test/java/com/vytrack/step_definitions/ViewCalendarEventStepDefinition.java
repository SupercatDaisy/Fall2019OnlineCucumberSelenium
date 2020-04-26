package com.vytrack.step_definitions;

import com.vytrack.pages.Activities.CalendarEventPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class ViewCalendarEventStepDefinition {

    CalendarEventPage calendarEventPage= new CalendarEventPage();

    @Then("View Per Page menu should have following options")
    public void view_Per_Page_menu_should_have_following_options(List<String> dataTable) {

        Assert.assertEquals(dataTable,calendarEventPage.getPerPageList());

     /*   for (int i = 0; i <calendarEventPage.getList().size() ; i++) {
            Assert.assertEquals(dataTable.get(i), calendarEventPage.getList().get(i));

        }*/


    }

}
