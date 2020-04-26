package com.vytrack.pages.Activities;

import com.vytrack.pages.PageBase;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarEventPage extends PageBase {

    @FindBy(css = "a[class='btn main-group btn-primary pull-right ']")
    private WebElement createCalendarEvent;


    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;



    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle']")
    private WebElement options;

    @FindBy(css = "input[type='number']")
    private WebElement defaulPageNumber;



    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;

    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;

    @FindBy(id = "tinymce")
    private WebElement textArea;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement SaveAndClose;

    @FindBy(xpath = "//label[text()='Description']/following-sibling::div//p[1]")
    private WebElement generalInfoDescription;

    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;

    @FindBy(css = "button[class='btn dropdown-toggle ']")
    private WebElement PerPageNumber;


    @FindBy(css = "ul[class='dropdown-menu pull-right']>li")
    private List<WebElement> PerPageList;


    public List<String> getPerPageList()
    {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        PerPageNumber.click();
        Wait.wait(2);
        return BrowserUtilities.getTextFromWebElements(PerPageList);
    }

    public void enterCalendarEventTitle(String titleValue) {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(title));
        Wait.wait(1);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
        wait.until(ExpectedConditions.attributeToBe(title,"value",titleValue));
        Wait.wait(1);
    }

    public void enterCalendarEventDescription(String description) {
        //wait until frame is available
        Wait.wait(2);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        wait.until(ExpectedConditions.visibilityOf(textArea));
        textArea.sendKeys(description);
        wait.until(ExpectedConditions.textToBePresentInElement(textArea,description));
        driver.switchTo().defaultContent();
        //exit from the frame
    }

    public String getGeneralInfoDescriptionText() {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div//div")));
        return generalInfoDescription.getText();
    }

        public String getGeneralInfoTitleText()
    {
        return generalInfoTitle.getText();
    }



    public void clickOnSaveAndClose()

    {
        wait.until(ExpectedConditions.elementToBeClickable(SaveAndClose));
        SaveAndClose.click();
}


        public String getPerPageNumber()
{
    return PerPageNumber.getText().trim();
}


public String getDefaultPageNumber()
{
    return defaulPageNumber.getAttribute("value").trim();
}

public String getOptions()
{
    BrowserUtilities.waitForPageToLoad(15);
    wait.until(ExpectedConditions.visibilityOf(options));
    return options.getText().trim();
}


public List<String> getColumnNames(){
    BrowserUtilities.waitForPageToLoad(20);
    Wait.wait(2);
    return BrowserUtilities.getTextFromWebElements(columnNames);
    }

public String getStartTime()
{
    BrowserUtilities.waitForPageToLoad(10);
    wait.until(ExpectedConditions.visibilityOf(startTime));
    return startTime.getAttribute("value");
}

public String getEndTime()
    {
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");

    }


public String getStartDate()
{
    BrowserUtilities.waitForPageToLoad(10);
    wait.until(ExpectedConditions.visibilityOf(startDate));
    return startDate.getAttribute("value");
}


public String getOwner()
{
    BrowserUtilities.waitForPageToLoad(10);
   // wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
    wait.until(ExpectedConditions.visibilityOf(owner));
    return owner.getText().trim();
}



public void clickToCreateEvent ()
{
    wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();

}





public void verifyName ()
{

}







}
