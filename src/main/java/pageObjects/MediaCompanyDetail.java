package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MediaCompanyDetail {
    public WebDriver driver;
    public MediaCompanyDetail(WebDriver driver)
    {
        this.driver = driver;
    }

    By breadcrumb = By.xpath("//div[@class='crumbs-ctn']");
    By breadcrumbRedirection = By.xpath("//div[@class='crumbs-ctn']/span[1]");
    By subscriberListing = By.xpath("//table[@role='table']/tbody/tr");
//    By searchedName = By.xpath("//table[@role='table']/tbody/tr[2]/td[1]");
//    By validateName = By.xpath("//table[@role='table']/tbody/tr[1]/td[1]");
//    By search = By.xpath("//input[@class='input-search-field']");
    public WebElement getBreadcrumb()
    {
        return driver.findElement(breadcrumb);
    }
    public WebElement getBreadcrumbRedirection()
    {
        return driver.findElement(breadcrumbRedirection);
    }
    public List<WebElement> getSubscriberListing()
    {
        return driver.findElements(subscriberListing);
    }
//    public WebElement getSearchedName()
//    {
//        return driver.findElement(searchedName);
//    }
//    public WebElement getValidateName()
//    {
//        return driver.findElement(validateName);
//    }
//    public WebElement getSearchField()
//    {
//        return driver.findElement(search);
//    }
}
