package com.vytrack.pages;


import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class will be extended by page classes. Common Webelements will be stored here.
 * Since navigation menu is same for all the pages.
 */

public abstract class PageBase {
  protected   WebDriver driver = Driver.getDriver(ConfigurationReader.getProperty("browser"));
  protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(ConfigurationReader.getProperty("browser")),10);

//put here because this is same for all the users
    @FindBy(css = "#user-menu > a")
    protected WebElement CurrentUser;

    public String getCurrentUserName()
    {
        wait.until(ExpectedConditions.visibilityOf(CurrentUser));
        return CurrentUser.getText().trim();
    }

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement SaveAndClose;

    public void clickOnSaveAndClose()
    {
        wait.until(ExpectedConditions.visibilityOf(SaveAndClose));
        SaveAndClose.click();
    }



   public PageBase()
   {
       PageFactory.initElements(Driver.getDriver(ConfigurationReader.getProperty("browser")),this);
   }


   public void navigateTo(String tabName,String moduleName)
   {
    String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'"+tabName+"')]";
    String moduleXpath = "//span[@class='title title-level-2' and text() = '"+moduleName+"']";
       WebElement tabElement = Driver.getDriver(ConfigurationReader.getProperty("browser")).findElement(By.xpath(tabNameXpath));
       WebElement moduleElement=Driver.getDriver(ConfigurationReader.getProperty("browser")).findElement(By.xpath(moduleXpath));
       Actions actions = new Actions(Driver.getDriver(ConfigurationReader.getProperty("browser")));
       Wait.wait(2);
       actions.moveToElement(tabElement).pause(2000).click(moduleElement).build().perform();
       Wait.wait(2);
       waitForLoaderMask();
   }
    /**
     * this method can be used to wait until that terrible loader mask (spinning wheel) will be gone
     * if loader mask is present, website is loading some data and you cannot perform any operations
     */
    public void waitForLoaderMask() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class*='loader-mask']")));
    }
}



