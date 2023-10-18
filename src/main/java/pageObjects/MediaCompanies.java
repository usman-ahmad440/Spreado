package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MediaCompanies {
    public WebDriver driver;
    public MediaCompanies(WebDriver driver)
    {
        this.driver = driver;
    }

    By title = By.xpath("//div[@class='flex space-between media-cmp-row']/h1");
    By listing = By.xpath("//tbody[@role='rowgroup']/tr");
    By activeInactive = By.xpath("//tbody[@role='rowgroup']/tr[1]/td[7]/div/div[2]");
    By confirmationPopupButton = By.xpath("//div[@class='confirmation-popup']/div[3]/button[1]");
    By mediaCompanyStatus = By.xpath("//tbody[@role='rowgroup']/tr[1]/td[4]");
    By search = By.xpath("//div[@class='r-search mb-3']/input");
    By searchedName = By.xpath("//table[@role='table']/tbody/tr[2]/td[1]");
    By validateName = By.xpath("//table[@role='table']/tbody/tr[1]/td[1]");
    By editButton = By.xpath("//tbody[@role='rowgroup']/tr[1]/td[7]/div/div[1]");
    By representativeNameField = By.xpath("//input[@name='representiveName']");
    By companyNameField = By.xpath("//input[@name='mediaCompany']");
    By checkBox = By.xpath("//input[@type='checkbox']");
    By submitButton = By.xpath("//button[@type='submit']");
    By closeModalBox = By.xpath("//img[@alt='modal-cross']");
    By companyName = By.xpath("//table[@role='table']/tbody/tr[1]/td[1]");
    By subscriberList = By.xpath("//tbody[@role='rowgroup']/tr/td[2]");
    By mediaCompanyClick = By.xpath("//tbody[@role='rowgroup']/tr[1]/td[1]");

    public WebElement getTitle()
    {
        return driver.findElement(title);
    }
    public List<WebElement> getmediaListing()
    {
        return driver.findElements(listing);
    }
    public WebElement getActiveInactiveButton()
    {
        return driver.findElement(activeInactive);
    }
    public WebElement getConfirmationPopupButton()
    {
        return driver.findElement(confirmationPopupButton);
    }
    public WebElement getMediaCompanyStatus()
    {
        return driver.findElement(mediaCompanyStatus);
    }
    public WebElement getSearch()
    {
        return driver.findElement(search);
    }
    public WebElement getSearchedName()
    {
        return driver.findElement(searchedName);
    }
    public WebElement getValidateName()
    {
        return driver.findElement(validateName);
    }
    public WebElement getEditButton()
    {
        return driver.findElement(editButton);
    }
    public WebElement getRepresentativeNameField()
    {
        return driver.findElement(representativeNameField);
    }
    public WebElement getCompanyNameField()
    {
        return driver.findElement(companyNameField);
    }
    public WebElement getCheckBox()
    {
        return driver.findElement(checkBox);
    }
    public WebElement getSubmitButton()
    {
        return driver.findElement(submitButton);
    }
    public WebElement getCloseModalBox()
    {
        return driver.findElement(closeModalBox);
    }
    public WebElement getCompanyName()
    {
        return driver.findElement(companyName);
    }
    public List<WebElement> getSubscriberListing()
    {
        return driver.findElements(subscriberList);
    }

    public String splitRepresentativeName(String str)
    {
        String[] parts = (str).split("\n");
        String part1 = parts[0];
        String part2 = parts[1];
        return part2;
    }

    public String splitCompanyName(String str)
    {
        String[] parts = (str).split("\n");
        String part1 = parts[0];
        String part2 = parts[1];
        return part1;
    }

    public String getCompanySubscribers(){
        List<WebElement> mediaListing = getmediaListing();
        if (mediaListing.size()>=1)
        {
            List<WebElement> subscriberList = getSubscriberListing();
            int findIndex = -1;
            String list;
            for (int i = 0; i < mediaListing.size(); i++) {
                list = subscriberList.get(i).getText();
                if (list.equals("")) {
                    findIndex = i;
                    findIndex++;
                    break;
                }
            }
            if (findIndex != -1) {
                String str = "//tbody[@role='rowgroup']/tr[" + findIndex + "]/td[1]";
                return str;
            }
            else
            {
                return "Not Found";
            }
        }
        else
        {
            return "Not Found";
        }
    }

    public WebElement getClickOnMediaCompany()
    {
        return driver.findElement(mediaCompanyClick);
    }
}
