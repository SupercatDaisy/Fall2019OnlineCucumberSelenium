package com.vytrack.step_definitions;

import com.vytrack.pages.fleet.VehiclesPage;
import com.vytrack.utilities.Wait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CreateCarStepDefinitions {


VehiclesPage vehiclesPage=new VehiclesPage();

    @Then("user click on create a car button")
    public void user_click_on_create_a_car_button() {
       vehiclesPage.clickToCreateCar();
    }

    @Then("user creates a car with following info:")
    public void user_creates_a_car_with_following_info(List<Map<String,String>> dataTable) {
        vehiclesPage.setLicencePlateInput(dataTable.get(0).get("License Plate"));
        vehiclesPage.setDriverInput(dataTable.get(0).get("Driver"));
        vehiclesPage.setLocationInput(dataTable.get(0).get("Location"));
        vehiclesPage.setModelYear(dataTable.get(0).get("Model Year"));
        vehiclesPage.setColor(dataTable.get(0).get("Color"));
        vehiclesPage.clickOnSaveAndClose();
        //If more than 1 row of data
       /* for(Map<String,String> row : dataTable)
        {
            vehiclesPage.setLicencePlateInput(row.get("License Plate"));
            vehiclesPage.setDriverInput(row.get("Driver"));
            vehiclesPage.setLocationInput(row.get("Location"));
            vehiclesPage.setModelYear(row.get("Model Year"));
            vehiclesPage.setColor(row.get("Color"));


        }
        */
    }
    @Then("user verifies that car info is displayed:")
    public void user_verifies_that_car_info_is_displayed(List<Map<String,String>> dataTable) {
        for(Map<String,String> row:dataTable){
            Assert.assertEquals(row.get("License Plate"),vehiclesPage.getCarGeneralInfo("License Plate"));
            Assert.assertEquals(row.get("Driver"),vehiclesPage.getCarGeneralInfo("Driver"));
            Assert.assertEquals(row.get("Location"),vehiclesPage.getCarGeneralInfo("Location"));
            Assert.assertEquals(row.get("Model Year"),vehiclesPage.getCarGeneralInfo("Model Year"));
            Assert.assertEquals(row.get("Color"),vehiclesPage.getCarGeneralInfo("Color"));
        }

    }



    }


