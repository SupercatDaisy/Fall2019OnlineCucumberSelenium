package com.vytrack.pages.fleet;


import com.vytrack.pages.PageBase;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPage extends PageBase {


    @FindBy(partialLinkText ="Create Car")
 private WebElement createCar;

    public void clickToCreateCar()
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver("remote_chrome"),10);
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();
    }


    @FindBy(css = "input[name='custom_entity_type[LicensePlate]']")
    private WebElement licencePlateInput;
    @FindBy(css="input[name='custom_entity_type[Driver]']")
    private WebElement driverInput;
    @FindBy (css="input[name='custom_entity_type[Location]']")
    private WebElement locationInput;
    @FindBy (css="input[name='custom_entity_type[ModelYear]']")
    private WebElement modelYear;
    @FindBy (css="input[name='custom_entity_type[Color]']")
    private WebElement color;
    @FindBy (xpath = "(//button[@type='submit'])[1]")
    private WebElement submit;
    public void setLicencePlateInput(String licencePlate){
        wait.until(ExpectedConditions.visibilityOf(licencePlateInput));
        licencePlateInput.sendKeys(licencePlate);
    }
    public void setDriverInput(String driver){
        driverInput.sendKeys(driver);
    }
    public void setLocationInput(String location){
        locationInput.sendKeys(location);
    }
    public void setModelYear(String year){
        modelYear.sendKeys(year);
    }
    public void setColor(String color){
        this.color.sendKeys(color);
    }
    public void submit(){
        submit.click();
    }

    public String getCarGeneralInfo(String parameter) {
        String xpath = "//label[text()='" + parameter + "']/following-sibling::div/div";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath)).getText().trim();
    }

}


