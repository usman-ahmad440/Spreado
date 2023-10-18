package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Dashboard;
import pageObjects.LoginPage;
import pageObjects.MediaCompanies;
import pageObjects.MediaCompanyDetail;
import resourses.Base;

import java.io.IOException;

public class SubscriberListing extends Base {
    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = InitializeDriver();
        driver.get(prop.getProperty("url"));

        LoginPage lp = new LoginPage(driver);
        lp.getEmailId().sendKeys(prop.getProperty("username"));
        lp.getPassword().sendKeys(prop.getProperty("password"));
        lp.getSigninButton().click();

        Dashboard db = new Dashboard(driver);
        db.getMediaCompany().click();
    }

    @Test
    public void validateSubscriberListing()
    {
        MediaCompanies mc = new MediaCompanies(driver);
        String str = mc.getCompanySubscribers();

        MediaCompanyDetail mcd = new MediaCompanyDetail(driver);

        if (str.compareTo("Not Found") != 0)
        {
            driver.findElement(By.xpath(str)).click();
            Assert.assertFalse(mcd.getSubscriberListing().isEmpty());
        }
    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}
