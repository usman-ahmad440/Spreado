package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard {

    By title = By.xpath("//div[@class='dasboard-barContent']/h1");
    By mediaCompany = By.xpath("//ul[@class='list-unstyled pb-3 custom-nav nav flex-column']/li[2]/a");

    WebDriver driver;
    public Dashboard(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getTitle()
    {
        return driver.findElement(title);
    }

    public WebElement getMediaCompany()
    {
        return driver.findElement(mediaCompany);


    }
}
