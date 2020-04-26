package com.vytrack.pages.fleet;

import com.vytrack.pages.PageBase;
import com.vytrack.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class VehiclesFuelLogsPage extends PageBase {

    @FindBy(partialLinkText ="Create Vehicle Fuel Logs")
    private WebElement CreateFuelLog;

    @FindBy(className = "fa-chevron-right hide-text")
    private WebElement nextPage;

    @FindBy(className = "oro-subtitle")
    private WebElement subTitle;

    @FindBy(className = "message")
    private List<WebElement> alertMessage;

    public List<String> getAlertMessages()
    {
        return BrowserUtilities.getTextFromWebElements(alertMessage);
    }

    public void CreateVehicleFuelLogs()
    {
        wait.until(ExpectedConditions.elementToBeClickable(CreateFuelLog)).click();

    }

    public String GetSubtTitle()
    {
        return subTitle.getText();
    }




}
